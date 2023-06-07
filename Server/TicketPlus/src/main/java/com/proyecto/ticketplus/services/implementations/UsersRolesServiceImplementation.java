package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.repositories.IUsersRolesRepository;
import com.proyecto.ticketplus.services.IUsersRolesService;

@Service
public class UsersRolesServiceImplementation implements IUsersRolesService{
	@Autowired
	private IUsersRolesRepository usersRolesRepository;
}