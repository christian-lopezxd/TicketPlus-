package com.proyecto.ticketplus.controllers;

import java.util.List;
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
import com.proyecto.ticketplus.models.entities.Roles;
import com.proyecto.ticketplus.services.IRolesService;

@RestController
@RequestMapping("/role")
@CrossOrigin("*")
public class RolesController {
	@Autowired
	private IRolesService rolesService;
	
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
	
	
	
	//PUT
	
	
	
	//PATCH
	
	
	
	//DELETE
	
	
}