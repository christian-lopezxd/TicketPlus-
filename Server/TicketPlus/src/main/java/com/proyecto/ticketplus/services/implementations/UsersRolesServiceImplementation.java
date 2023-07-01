package com.proyecto.ticketplus.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.models.dtos.users_roles.UserRoleDTO;
import com.proyecto.ticketplus.models.entities.Roles;
import com.proyecto.ticketplus.models.entities.Users;
import com.proyecto.ticketplus.models.entities.UsersRoles;
import com.proyecto.ticketplus.repositories.IUsersRolesRepository;
import com.proyecto.ticketplus.services.IUsersRolesService;

import jakarta.transaction.Transactional;

@Service
public class UsersRolesServiceImplementation implements IUsersRolesService{
	@Autowired
	private IUsersRolesRepository usersRolesRepository;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void RegisterRoleToUser(Users user, Roles role) throws Exception {
		UsersRoles newUserRoles = new UsersRoles(
				user,
				role
				);
		
		usersRolesRepository.save(newUserRoles);
	}

	@Override
	public UsersRoles findUsersRolesByUserAndRole(Users user, Roles role) {
		return usersRolesRepository.findUsersRolesByUserAndRole(user, role);
	}

	@Override
	public UserRoleDTO findUsersRolesByUser(Users user) {
		UserRoleDTO userRoles = new UserRoleDTO(
				user,
				null
				);
		
		List<UsersRoles> userRolesList = usersRolesRepository.findUsersRolesByUser(user);
		
		if (userRolesList.size() > 0) {
			List<Roles> roles =  new ArrayList<Roles>();
			
			for (int i = 0; i < userRolesList.size(); i++) {
				roles.add(userRolesList.get(i).getRole());
			}
			
			userRoles.setRoles(roles);
			
			return userRoles;
		}
		
		return userRoles;
	}
}