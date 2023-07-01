package com.proyecto.ticketplus.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ticketplus.models.dtos.response.MessageDTO;
import com.proyecto.ticketplus.models.dtos.users.UserDTO;
import com.proyecto.ticketplus.models.dtos.users_roles.UserRoleDTO;
import com.proyecto.ticketplus.models.entities.Users;
import com.proyecto.ticketplus.services.IUsersRolesService;
import com.proyecto.ticketplus.services.IUsersService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private IUsersService userService;
	
	@Autowired
	private IUsersRolesService usersRolesService;
	
	//GET
	
	@GetMapping("/get-one/{idUser}")
	private ResponseEntity<?> getUser(@PathVariable("idUser") UUID idUser) {
		Users user = userService.findOneByUUID(idUser);
		
		if (user == null) {
			return new ResponseEntity<>(new MessageDTO("User not found"), HttpStatus.NOT_FOUND);
		}
		
		UserDTO showUser = new UserDTO(
				user.getIdUser(),
				user.getName(),
				user.getEmail(),
				user.getVerified(),
				user.getActive()
				);
		
		return  new ResponseEntity<>(showUser, HttpStatus.OK);
	}
	
	@GetMapping("/get-roles/{idUser}")
	private ResponseEntity<?> getEventTiers(@PathVariable("idUser") UUID idUser) {
		Users user = userService.findOneByUUID(idUser);
		
		if (user == null) {
			return new ResponseEntity<>(new MessageDTO("User not found"), HttpStatus.NOT_FOUND);
		}
		
		UserRoleDTO userRoles = usersRolesService.findUsersRolesByUser(user);
		
		return  new ResponseEntity<>(userRoles, HttpStatus.OK);
	}
	
	
	//POST
	
	
	
	//PUT
	
	
	
	//PATCH
	
	
	
	//DELETE
	
	
}