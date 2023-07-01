package com.proyecto.ticketplus.services;

import java.util.List;
import java.util.UUID;

import com.proyecto.ticketplus.models.entities.Roles;

public interface IRolesService {
	Roles findOneByidRole(UUID idRole);
	Roles findOneByName(String role);
	List<Roles> getAllRoles();
}