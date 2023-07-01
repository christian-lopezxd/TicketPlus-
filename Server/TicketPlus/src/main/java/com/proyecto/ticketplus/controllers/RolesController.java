package com.proyecto.ticketplus.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ticketplus.models.dtos.response.MessageDTO;
import com.proyecto.ticketplus.models.dtos.users_roles.NewUserRoleDTO;
import com.proyecto.ticketplus.models.entities.Roles;
import com.proyecto.ticketplus.models.entities.Users;
import com.proyecto.ticketplus.models.entities.UsersRoles;
import com.proyecto.ticketplus.services.IRolesService;
import com.proyecto.ticketplus.services.IUsersRolesService;
import com.proyecto.ticketplus.services.IUsersService;
import com.proyecto.ticketplus.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/role")
@CrossOrigin("*")
public class RolesController {
	@Autowired
	private IRolesService rolesService;
	
	@Autowired
	private IUsersService userService;
	
	@Autowired
	private IUsersRolesService usersRolesService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	//GET
	
	@GetMapping("/get-all")
	private ResponseEntity<?> getRoles() {
		List<Roles> roles = rolesService.getAllRoles();
		
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	@GetMapping("/get-one/uuid/{idRole}")
	private ResponseEntity<?> getRole(@PathVariable("idRole") UUID idRole) {
		Roles role = rolesService.findOneByidRole(idRole);
		
		if (role == null) {
			return new ResponseEntity<>(new MessageDTO("Role not found"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(role, HttpStatus.OK);
	}
	
	@GetMapping("/get-one/name/{roleName}")
	private ResponseEntity<?> getRole(@PathVariable("roleName") String roleName) {
		Roles role = rolesService.findOneByName(roleName);
		
		if (role == null) {
			return new ResponseEntity<>(new MessageDTO("Role not found"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(role, HttpStatus.OK);
	}
	
	//POST
	
	@PostMapping("/assign")
	private ResponseEntity<?> assignRoleToUser(@RequestBody @Valid NewUserRoleDTO data, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
		}
		
		Users user = userService.findOneByUUID(data.getIdUser());
		
		if (user == null) {
			return new ResponseEntity<>(new MessageDTO("User not found"), HttpStatus.NOT_FOUND);
		}
		
		Roles role = rolesService.findOneByidRole(data.getIdRole());
		
		if (role == null) {
			return new ResponseEntity<>(new MessageDTO("Role not found"), HttpStatus.NOT_FOUND);
		}
		
		try {
			UsersRoles userRole = usersRolesService.findUsersRolesByUserAndRole(user, role);
			
			if (userRole != null) {
				return new ResponseEntity<>(new MessageDTO("Role already assigned to User"), HttpStatus.CONFLICT);
			}
			
			usersRolesService.RegisterRoleToUser(user, role);
			
			return new ResponseEntity<>(new MessageDTO("Role assigned to User successfully"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new MessageDTO("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//PUT
	
	
	
	//PATCH
	
	
	
	//DELETE
	
	
}