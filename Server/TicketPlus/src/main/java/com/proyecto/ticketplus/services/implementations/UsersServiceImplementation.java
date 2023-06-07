package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.repositories.IUsersRepository;
import com.proyecto.ticketplus.services.IUsersService;

@Service
public class UsersServiceImplementation implements IUsersService{
	@Autowired
	private  IUsersRepository usersRepository;
}