package com.proyecto.ticketplus.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ticketplus.models.dtos.response.EmailDetailsDTO;
import com.proyecto.ticketplus.models.entities.Users;
import com.proyecto.ticketplus.services.IEmailService;
import com.proyecto.ticketplus.services.IUsersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/guest")
@CrossOrigin("*")
public class GuestController {
	@Autowired
	private IUsersService userService;
	
	@Autowired
	private IEmailService emailService;
	//GET
	
	@GetMapping("/prueba/{code}")
	private ResponseEntity<?> prueba(@PathVariable("code") String code) {
		Users user = userService.findOneByEmail(code);
		
		EmailDetailsDTO emailDetails = new EmailDetailsDTO(
				user.getEmail(),
				"Prueba ",
				"email con imagen",
				"logo.png"
				);
		
		emailService.sendSimpleMail(emailDetails);
		
		return new ResponseEntity<>("llega", HttpStatus.OK);
	}
	
	@GetMapping("/user/toggle-active/{idUser}")
	public ResponseEntity<?> changeUserStatus(@PathVariable("idUser") UUID idUser) {
		
		
		return new ResponseEntity<>("User activated", HttpStatus.OK);
	}
	
	//PATCH
	
	@PatchMapping("/user/toggle-active/{idUser}")
	public ResponseEntity<?> changeUserStatus(@Valid @RequestBody String data) {
		// TODO activate user and send email confirming user account activation
		return null;
	}
}