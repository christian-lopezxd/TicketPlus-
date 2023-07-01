package com.proyecto.ticketplus.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ticketplus.models.dtos.response.MessageDTO;
import com.proyecto.ticketplus.models.dtos.response.SendImageDTO;
import com.proyecto.ticketplus.models.entities.Users;
import com.proyecto.ticketplus.services.IEventsService;
import com.proyecto.ticketplus.services.IUsersService;

@RestController
@RequestMapping("/guest")
@CrossOrigin("*")
public class GuestController {
	@Autowired
	private IUsersService userService;
	
	@Autowired
	private IEventsService eventService;
	
	//GET
	
	@GetMapping("/prueba")
	private ResponseEntity<?> prueba() {
		return new ResponseEntity<>(new MessageDTO("Reaching server!"), HttpStatus.OK);
	}
	
	@GetMapping("/event/picture/{fileName}")
	private ResponseEntity<?> getPicture(@PathVariable("fileName") String fileName) {
		try {
			
			SendImageDTO imageData = new SendImageDTO(eventService.downloadImageFromFileSystem(fileName));
			
			if (imageData.getImage() == null) {
				return new ResponseEntity<>(new MessageDTO("Image not found"), HttpStatus.NOT_FOUND);
			}
			
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Content-Type", "image/png");
			
			return new ResponseEntity<>(imageData.getImage(), responseHeaders, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new MessageDTO("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
			return new ResponseEntity<>(new MessageDTO("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}