package com.proyecto.ticketplus.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.proyecto.ticketplus.models.entities.Roles;
import com.proyecto.ticketplus.models.entities.Users;
import com.proyecto.ticketplus.models.entities.UsersRoles;

public interface IUsersRolesRepository extends ListCrudRepository<UsersRoles, UUID> {
	UsersRoles findUsersRolesByUserAndRole(Users user, Roles role);
	List<UsersRoles> findUsersRolesByUser(Users user);
}