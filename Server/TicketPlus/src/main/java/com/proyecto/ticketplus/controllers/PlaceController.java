package com.proyecto.ticketplus.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ticketplus.models.dtos.places.CreatePlaceDTO;
import com.proyecto.ticketplus.models.dtos.response.MessageDTO;
import com.proyecto.ticketplus.models.dtos.response.PageListDTO;
import com.proyecto.ticketplus.models.entities.Places;
import com.proyecto.ticketplus.services.IPlacesService;
import com.proyecto.ticketplus.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/place")
@CrossOrigin("*")
public class PlaceController {
	@Autowired
	private IPlacesService placeService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	//GET
	
	@GetMapping("/get-all")
	private ResponseEntity<?> getPlaces(@RequestParam(required = false, name = "page", defaultValue = "0") int page, @RequestParam(required = false, name = "size", defaultValue = "10") int size) {
		PageListDTO<Places> places = placeService.findAllPlaces(page, size);
		
		return new ResponseEntity<>(places, HttpStatus.OK);
	}
	
	@GetMapping("/get-one/{idPlace}")
	private ResponseEntity<?> getPlace(@PathVariable("idPlace") UUID idPlace) {
		Places place = placeService.findPlaceByUUID(idPlace);
		
		if (place == null) {
			return new ResponseEntity<>(new MessageDTO("Place not found"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(place, HttpStatus.OK);
	}
	
	//POST
	
	@PostMapping("/create")
	private ResponseEntity<?> createPlace(@RequestBody @Valid CreatePlaceDTO data, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
		}
		
		try {
			placeService.RegisterPlace(data);
			
			return new ResponseEntity<>(new MessageDTO("Place added successfully"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new MessageDTO("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//PUT
	
	
	
	//PATCH
	
	
	
	//DELETE
	
	
}