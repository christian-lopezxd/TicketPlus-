package com.proyecto.ticketplus.services;

import java.util.UUID;

import com.proyecto.ticketplus.models.dtos.users.ChangePasswordDTO;
import com.proyecto.ticketplus.models.dtos.users.NewUserGoogleDTO;
import com.proyecto.ticketplus.models.dtos.users.NewUserPasswordDTO;
import com.proyecto.ticketplus.models.entities.Roles;
import com.proyecto.ticketplus.models.entities.Tokens;
import com.proyecto.ticketplus.models.entities.Users;

public interface IUsersService {
	//General
	Users findOneByEmail(String email);
	Users findOneByUUID(UUID idUser);
	
	//Token management
	Tokens registerToken(Users user) throws Exception;
	Boolean isTokenValid(Users user, String token);
	void cleanTokens(Users user) throws Exception;
	void cleanTokens() throws Exception;
	
	//Auth
	void assignRoleToUser(Users user, Roles rol) throws Exception;
	void createUserGoogle(NewUserGoogleDTO newUserGoogle) throws Exception;
	void createUserPassword(NewUserPasswordDTO newUserPassword) throws Exception;
	String verifyIdTokenGoogle(String idToken);
	void signUpPassword(Users user, ChangePasswordDTO data) throws Exception;
	Boolean comparePassword(String toCompare, String current);
	void toggleVerifyUser(Users user) throws Exception;
	void toggleVerifyActive(Users user) throws Exception;
	void BanUser(Users user, String reason) throws Exception;
	Users findUserAuthenticated();
}