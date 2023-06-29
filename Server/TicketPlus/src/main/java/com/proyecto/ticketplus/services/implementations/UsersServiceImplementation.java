package com.proyecto.ticketplus.services.implementations;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.proyecto.ticketplus.models.dtos.users.ChangePasswordDTO;
import com.proyecto.ticketplus.models.dtos.users.NewUserDTO;
import com.proyecto.ticketplus.models.entities.Tokens;
import com.proyecto.ticketplus.models.entities.Users;
import com.proyecto.ticketplus.repositories.ITokensRepository;
import com.proyecto.ticketplus.repositories.IUsersRepository;
import com.proyecto.ticketplus.services.IEmailService;
import com.proyecto.ticketplus.services.IUsersService;
import com.proyecto.ticketplus.utils.JWTTools;

import jakarta.transaction.Transactional;

@Service
public class UsersServiceImplementation implements IUsersService{
	@Value("${google.ClientId}")
	private String clientId;
	
	@Autowired
	private  IUsersRepository usersRepository;
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	private JWTTools jwtTools;
	
	@Autowired
	private ITokensRepository tokenRepository;
	
	@Autowired
	private IEmailService emailService;
	
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
			
			tokens.stream()
				.filter(tk -> tk.getContent().equals(token))
				.findAny()
				.orElseThrow(() -> new Exception());
			
			return true;
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
	public void createUserGoogle(NewUserDTO newUserGoogle) throws Exception {
		Users user = findOneByEmail(newUserGoogle.getEmail());
		
		if (user != null) {
			Users newUser = new Users(
					newUserGoogle.getName(),
					newUserGoogle.getEmail(),
					null
					);
			
			usersRepository.save(newUser);
			
			emailService.sendCreationEmail(newUser.getEmail());
		}
	}
	
	@Override
	public String verifyIdTokenGoogle(String idToken) {
		NetHttpTransport transport = new NetHttpTransport();
		JsonFactory jsonFactory = GsonFactory.getDefaultInstance();
		
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory).setAudience(Collections.singletonList(clientId)).build();
		
	    try {
            GoogleIdToken idTokenObj = verifier.verify(idToken);
            
            if (idTokenObj == null) {
            	 System.out.println("Bad token format");
                return null;
            }
            
            GoogleIdToken.Payload payload = idTokenObj.getPayload();
            
            NewUserDTO newUserGoogle = new NewUserDTO(
            		(String) payload.get("given_name") + " " + (String) payload.get("family_name"),
            		payload.getEmail()
            		);
            
            createUserGoogle(newUserGoogle);
            
            return newUserGoogle.getEmail();
        } catch (Exception e) {
        	e.printStackTrace();
        }
	    
		return null;
	}
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void signUpPassword(Users user, ChangePasswordDTO data) throws Exception {
		user.setVerified(false);
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
		user.setVerified(true);
		
		usersRepository.save(user);
	}
}