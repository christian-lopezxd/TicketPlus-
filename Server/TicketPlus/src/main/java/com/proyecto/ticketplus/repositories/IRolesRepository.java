package com.proyecto.ticketplus.repositories;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.proyecto.ticketplus.models.entities.Roles;

public interface IRolesRepository extends ListCrudRepository<Roles, UUID> {
	Roles findOneByidRole(UUID idRole);
	Roles findOneByroleName(String roleName);
}