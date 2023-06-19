package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.models.dtos.users.ChangePasswordDTO;
import com.proyecto.ticketplus.models.entities.Users;
import com.proyecto.ticketplus.repositories.IUsersRepository;
import com.proyecto.ticketplus.services.IUsersService;

import jakarta.transaction.Transactional;

@Service
public class UsersServiceImplementation implements IUsersService{
	@Autowired
	private  IUsersRepository usersRepository;
	
	@Autowired
	public PasswordEncoder passwordEncoder;

	@Override
	public Users findOneByEmail(String email) {
		Users user = usersRepository.findOneByEmail(email);
		
		if (user == null) {
			return null;
		}
		
		return user;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public Void signUpPassword(Users user, ChangePasswordDTO data) throws Exception {
		user.setVerified(false);
		user.setPassword(passwordEncoder.encode(data.getNewPassword()));
		
		usersRepository.save(user);
		
		//TODO send email to confirm login with password activation 
		
		return null;
	}
}