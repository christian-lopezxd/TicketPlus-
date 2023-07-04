package com.proyecto.ticketplus.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ticketplus.models.dtos.response.MessageDTO;
import com.proyecto.ticketplus.models.dtos.users.DeactivationDTO;
import com.proyecto.ticketplus.models.dtos.users.UserDTO;
import com.proyecto.ticketplus.models.dtos.users_roles.UserRoleDTO;
import com.proyecto.ticketplus.models.entities.Users;
import com.proyecto.ticketplus.services.IUsersRolesService;
import com.proyecto.ticketplus.services.IUsersService;
import com.proyecto.ticketplus.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private IUsersService userService;
	
	@Autowired
	private IUsersRolesService usersRolesService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	//GET
	
	@GetMapping("/get")
	private ResponseEntity<?> getUserToken() {
		Users user = userService.findUserAuthenticated();
		
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
	
	@PatchMapping("/toggle-verify/{idUser}")
	public ResponseEntity<?> changeUserStatusVerify(@PathVariable("idUser") UUID idUser) {
		Users user = userService.findOneByUUID(idUser);
		
		if (user == null) {
			return new ResponseEntity<>(new MessageDTO("User do not exits!"), HttpStatus.NOT_FOUND);
		}
		
		try {
			userService.toggleVerifyUser(user);
			
			return new ResponseEntity<>(new MessageDTO("Verify status set to '" + user.getVerified() + "', User changed successfully"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new MessageDTO("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/toggle-active/{idUser}")
	public ResponseEntity<?> changeUserStatusActive(@PathVariable("idUser") UUID idUser) {
		Users user = userService.findOneByUUID(idUser);
		
		if (user == null) {
			return new ResponseEntity<>(new MessageDTO("User do not exits!"), HttpStatus.NOT_FOUND);
		}
		
		try {
			userService.toggleVerifyActive(user);
			
			return new ResponseEntity<>(new MessageDTO("Active status set to '" + user.getActive() + "', User changed successfully"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new MessageDTO("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/ban/{idUser}")
	public ResponseEntity<?> changeUserBan(@RequestBody @Valid DeactivationDTO data, BindingResult validations, @PathVariable("idUser") UUID idUser) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
		}
		
		Users user = userService.findOneByUUID(idUser);
		
		if (user == null) {
			return new ResponseEntity<>(new MessageDTO("User do not exits!"), HttpStatus.NOT_FOUND);
		}
		
		try {
			userService.BanUser(user, data.getReason());
			
			return new ResponseEntity<>(new MessageDTO("Active status set to '" + user.getActive() + "', User banned successfully"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new MessageDTO("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//DELETE
	
	
}