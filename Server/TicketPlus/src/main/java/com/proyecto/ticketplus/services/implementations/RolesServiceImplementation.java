package com.proyecto.ticketplus.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.models.entities.Roles;
import com.proyecto.ticketplus.repositories.IRolesRepository;
import com.proyecto.ticketplus.services.IRolesService;

@Service
public class RolesServiceImplementation implements IRolesService{
	@Autowired
	private IRolesRepository rolesRepository;

	@Override
	public Roles findOneByidRole(UUID idRole) {
		return rolesRepository.findOneByidRole(idRole);
	}
	
	@Override
	public Roles findOneByName(String role) {
		return rolesRepository.findOneByroleName(role);
	}

	@Override
	public List<Roles> getAllRoles() {
		return rolesRepository.findAll();
	}
}