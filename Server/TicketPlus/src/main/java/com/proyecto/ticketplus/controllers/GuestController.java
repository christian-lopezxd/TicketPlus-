package com.proyecto.ticketplus.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ticketplus.models.dtos.response.EmailDetailsDTO;
import com.proyecto.ticketplus.models.dtos.response.MessageDTO;
import com.proyecto.ticketplus.models.entities.Users;
import com.proyecto.ticketplus.services.IEmailService;
import com.proyecto.ticketplus.services.IUsersService;

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
		
		return new ResponseEntity<>(new MessageDTO("llega"), HttpStatus.OK);
	}
	
	//PATCH
	
	@PatchMapping("/user/toggle-verify/{idUser}")
	public ResponseEntity<?> changeUserStatus(@PathVariable("idUser") UUID idUser) {
		Users user = userService.findOneByUUID(idUser);
		
		if (user == null) {
			return new ResponseEntity<>(new MessageDTO("User do not exits!"), HttpStatus.NOT_FOUND);
		}
		
		if (user.getVerified()) {
			return new ResponseEntity<>(new MessageDTO("User account already verified!"), HttpStatus.CONFLICT);
		}
		
		if (!user.getActive()) {
			return new ResponseEntity<>(new MessageDTO("User account deactivated! Make sure to contact an administrator"), HttpStatus.UNAUTHORIZED);
		}
		
		try {
			userService.toggleVerifyUser(user);
			
			return new ResponseEntity<>(new MessageDTO("User account verified successfully"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}