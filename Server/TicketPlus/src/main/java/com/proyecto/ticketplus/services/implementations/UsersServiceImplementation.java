package com.proyecto.ticketplus.services.implementations;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.proyecto.ticketplus.models.dtos.users.ChangePasswordDTO;
import com.proyecto.ticketplus.models.dtos.users.NewUserGoogleDTO;
import com.proyecto.ticketplus.models.dtos.users.NewUserPasswordDTO;
import com.proyecto.ticketplus.models.entities.Roles;
import com.proyecto.ticketplus.models.entities.Tokens;
import com.proyecto.ticketplus.models.entities.Users;
import com.proyecto.ticketplus.models.entities.UsersRoles;
import com.proyecto.ticketplus.repositories.ITokensRepository;
import com.proyecto.ticketplus.repositories.IUsersRepository;
import com.proyecto.ticketplus.repositories.IUsersRolesRepository;
import com.proyecto.ticketplus.services.IEmailService;
import com.proyecto.ticketplus.services.IRolesService;
import com.proyecto.ticketplus.services.IUsersService;
import com.proyecto.ticketplus.utils.JWTTools;

import jakarta.transaction.Transactional;

@Service
public class UsersServiceImplementation implements IUsersService {	
	@Autowired
	private  IUsersRepository usersRepository;
	
	@Autowired
	private ITokensRepository tokenRepository;
	
	@Autowired
	private IUsersRolesRepository userRolesRepository;
	
	@Autowired
	private IEmailService emailService;
	
	@Autowired
	private IRolesService rolesService;
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	private JWTTools jwtTools;
	
	private final GoogleIdTokenVerifier verifier;

    public UsersServiceImplementation(@Value("${Client_ID}") String clientId) {
        NetHttpTransport transport = new NetHttpTransport();
        JacksonFactory jsonFactory = new JacksonFactory();
        
        verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory).setAudience(Collections.singletonList(clientId)).build();
    }
	
	//General
	@Override
	public Users findOneByEmail(String email) {
		Users user = usersRepository.findOneByEmail(email);
		
		if (user == null) {
			return null;
		}
		
		return user;
	}
	
	@Override
	public Users findOneByUUID(UUID idUser) {
		Users user = usersRepository.findOneByIdUser(idUser);
		
		if (user == null) {
			return null;
		}
		
		return user;
	}
	
	//Token management
	@Override
	@Transactional(rollbackOn = Exception.class)
	public Tokens registerToken(Users user) throws Exception {
		cleanTokens(user);
		
		String tokenString = jwtTools.generateToken(user);
		Tokens token = new Tokens(tokenString, user);
		
		tokenRepository.save(token);
		
		return token;
	}
	
	@Override
	public Boolean isTokenValid(Users user, String token) {
		try {
			cleanTokens(user);
			List<Tokens> tokens = tokenRepository.findByUserAndActive(user, true);
			
			if (tokens.size() > 0) {
				tokens.stream()
				.filter(tk -> tk.getContent().equals(token))
				.findAny()
				.orElseThrow(() -> new Exception());
			
				return true;
			}
			
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void cleanTokens(Users user) throws Exception {
		List<Tokens> tokens = tokenRepository.findByUserAndActive(user, true);
		
		tokens.forEach(token -> {
			if(!jwtTools.verifyToken(token.getContent())) {
				token.setActive(false);
				tokenRepository.save(token);
			}
		});
	}
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void cleanTokens() throws Exception {
		List<Tokens> tokens = tokenRepository.findByActive(false);
		tokenRepository.deleteAll(tokens);
	}
	
	//Auth
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void assignRoleToUser(Users user, Roles rol) throws Exception {
		UsersRoles newUserRole = new UsersRoles(
				user,
				rol
				);
		
		userRolesRepository.save(newUserRole);
	}
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void createUserGoogle(NewUserGoogleDTO newUserGoogle) throws Exception {
		Users user = findOneByEmail(newUserGoogle.getEmail());
		
		if (user == null) {
			Users newUser = new Users(
					newUserGoogle.getName(),
					newUserGoogle.getEmail(),
					null,
					false,
					true
					);
			
			UUID idUser = usersRepository.save(newUser).getIdUser();
			
			Users userCreated = findOneByUUID(idUser);
			Roles role = rolesService.findOneByName("Customer");
			
			assignRoleToUser(userCreated, role);
			
			emailService.sendCreationEmail(newUser.getEmail());
			emailService.sendVerificationEmail(newUser.getEmail(), idUser);
		}
	}
	
	@Override
	public void createUserPassword(NewUserPasswordDTO newUserPassword) throws Exception {
		Users newUser = new Users(
				newUserPassword.getName(),
				newUserPassword.getEmail(),
				passwordEncoder.encode(newUserPassword.getPassword()),
				false,
				true
				);
		
		UUID idUser = usersRepository.save(newUser).getIdUser();
		
		System.out.println(findOneByEmail(newUserPassword.getEmail()));
		
		Users userCreated = findOneByUUID(idUser);	
		Roles role = rolesService.findOneByName("Customer");
		
		assignRoleToUser(userCreated, role);
		
		emailService.sendCreationEmail(newUser.getEmail());
		emailService.sendVerificationEmail(newUser.getEmail(), idUser);
	}
	
	@Override
	public String verifyIdTokenGoogle(String idToken) {
        GoogleIdToken idTokenObject = null;

        try {
            idTokenObject = verifier.verify(idToken);

            if (idToken == null)
                return null;

            GoogleIdToken.Payload payload = idTokenObject.getPayload();
            
            NewUserGoogleDTO newUserGoogle = new NewUserGoogleDTO(
            		(String) payload.get("given_name") + " " + (String) payload.get("family_name"),
            		payload.getEmail()
            		);
            
            createUserGoogle(newUserGoogle);

            return newUserGoogle.getEmail();
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
			e.printStackTrace();
		}
        
		return null;
    }
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void signUpPassword(Users user, ChangePasswordDTO data) throws Exception {
		toggleVerifyUser(user);
		user.setPassword(passwordEncoder.encode(data.getNewPassword()));
		
		usersRepository.save(user);
		
		emailService.sendSignUpEmail(user.getEmail());
		emailService.sendVerificationEmail(user.getEmail(), user.getIdUser());
	}

	@Override
	public Boolean comparePassword(String toCompare, String current) {
		return passwordEncoder.matches(toCompare, current);
	}

	@Override
	public void toggleVerifyUser(Users user) throws Exception {
		if (!user.getVerified()) {
			user.setVerified(true);
		} else {
			user.setVerified(false);
		}
		
		usersRepository.save(user);
	}
	
	@Override
	public void toggleVerifyActive(Users user) throws Exception {
		if (!user.getActive()) {
			user.setActive(true);
		} else {
			user.setActive(false);
		}
		
		usersRepository.save(user);
	}
	
	@Override
	public void BanUser(Users user, String reason) throws Exception {
		user.setActive(false);
		
		usersRepository.save(user);
		
		emailService.sendDeactivationEmail(user.getEmail(), reason);
	}

	@Override
	public Users findUserAuthenticated() {
		return (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}