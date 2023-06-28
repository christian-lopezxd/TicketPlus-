package com.proyecto.ticketplus.services;

import com.proyecto.ticketplus.models.dtos.users.ChangePasswordDTO;
import com.proyecto.ticketplus.models.dtos.users.NewUserDTO;
import com.proyecto.ticketplus.models.entities.Users;

public interface IUsersService {
	//General
	Users findOneByEmail(String email);
	
	//Auth
	void createUserGoogle(NewUserDTO newUserGoogle) throws Exception;
	String verifyIdTokenGoogle(String idToken);
	void signUpPassword(Users user, ChangePasswordDTO data) throws Exception;
	Boolean comparePassword(String toCompare, String current);
}