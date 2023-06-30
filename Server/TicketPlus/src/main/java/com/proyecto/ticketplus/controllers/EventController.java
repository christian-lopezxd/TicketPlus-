package com.proyecto.ticketplus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ticketplus.models.dtos.events.CreateEventDTO;
import com.proyecto.ticketplus.models.dtos.response.MessageDTO;
import com.proyecto.ticketplus.models.entities.EventCategories;
import com.proyecto.ticketplus.models.entities.Places;
import com.proyecto.ticketplus.services.IEventCategoriesService;
import com.proyecto.ticketplus.services.IEventsService;
import com.proyecto.ticketplus.services.IPlacesService;
import com.proyecto.ticketplus.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/event")
@CrossOrigin("*")
public class EventController {
	@Autowired
	private IEventsService eventService;
	
	@Autowired
	private IEventCategoriesService eventCategoriesService;
	
	@Autowired
	private IPlacesService placesService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	//GET
	
	
	
	//POST
	
	@PostMapping("/create")
	private ResponseEntity<?> eventCreate(@ModelAttribute @Valid CreateEventDTO data, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
		}
		
		EventCategories eventCatergory = eventCategoriesService.findEventCategoryByUUID(data.getEventCategory());
		
		if (eventCatergory == null) {
			return new ResponseEntity<>(new MessageDTO("Event category not found"), HttpStatus.NOT_FOUND);
		}
		
		Places place = placesService.findPlaceByUUID(data.getPlace());
		
		if (place == null) {
			return new ResponseEntity<>(new MessageDTO("Place not found"), HttpStatus.NOT_FOUND);
		}
		
		try {
			eventService.registerEvent(data, eventCatergory, place);
			
			return new ResponseEntity<>(new MessageDTO("Event created successfully"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new MessageDTO("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//PUT
	
	
	
	//PATCH
	
	
	
	//DELETE
	
	
}