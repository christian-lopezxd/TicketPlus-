package com.proyecto.ticketplus.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
@CrossOrigin("*")
public class GuestController {
	//GET
	
	@GetMapping("/prueba")
	private ResponseEntity<?> prueba() {
		return new ResponseEntity<>("llega", HttpStatus.OK);
	}
}