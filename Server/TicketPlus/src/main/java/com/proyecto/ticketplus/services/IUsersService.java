package com.proyecto.ticketplus.services;

import com.proyecto.ticketplus.models.dtos.users.ChangePasswordDTO;
import com.proyecto.ticketplus.models.entities.Users;

public interface IUsersService {
	//Auth
	Users findOneByEmail(String email);
	Void signUpPassword(Users user, ChangePasswordDTO data) throws Exception;
}