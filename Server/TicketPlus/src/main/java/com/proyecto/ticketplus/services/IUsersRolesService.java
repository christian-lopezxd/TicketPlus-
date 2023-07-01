package com.proyecto.ticketplus.services;

import com.proyecto.ticketplus.models.dtos.users_roles.UserRoleDTO;
import com.proyecto.ticketplus.models.entities.Roles;
import com.proyecto.ticketplus.models.entities.Users;
import com.proyecto.ticketplus.models.entities.UsersRoles;

public interface IUsersRolesService {
	void RegisterRoleToUser(Users user, Roles role) throws Exception;
	UsersRoles findUsersRolesByUserAndRole(Users user, Roles role);
	UserRoleDTO findUsersRolesByUser(Users user);
}