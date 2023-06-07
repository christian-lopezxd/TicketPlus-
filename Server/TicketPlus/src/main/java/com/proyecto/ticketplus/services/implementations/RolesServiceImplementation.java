package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.repositories.IRolesRepository;
import com.proyecto.ticketplus.services.IRolesService;

@Service
public class RolesServiceImplementation implements IRolesService{
	@Autowired
	private IRolesRepository rolesRepository;
}