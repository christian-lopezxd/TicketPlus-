package com.proyecto.ticketplus.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ticketplus.models.dtos.events.CreateEventDTO;
import com.proyecto.ticketplus.models.dtos.events.UpdateEventDTO;
import com.proyecto.ticketplus.models.dtos.response.MessageDTO;
import com.proyecto.ticketplus.models.dtos.response.PageListDTO;
import com.proyecto.ticketplus.models.dtos.response.PageObjectDTO;
import com.proyecto.ticketplus.models.dtos.tiers.CreateTierDTO;
import com.proyecto.ticketplus.models.dtos.tiers.TiersEventDTO;
import com.proyecto.ticketplus.models.entities.EventCategories;
import com.proyecto.ticketplus.models.entities.Events;
import com.proyecto.ticketplus.models.entities.Places;
import com.proyecto.ticketplus.services.IEventCategoriesService;
import com.proyecto.ticketplus.services.IEventsService;
import com.proyecto.ticketplus.services.IPlacesService;
import com.proyecto.ticketplus.services.ITiersService;
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
	private ITiersService tiersService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	//GET
	
	@GetMapping("/get-all")
	private ResponseEntity<?> getEvents(@RequestParam(required = false, name = "page", defaultValue = "0") int page, @RequestParam(required = false, name = "size", defaultValue = "10") int size) {
		PageListDTO<Events> events = eventService.getAllEvents(page, size);
		
		return new ResponseEntity<>(events, HttpStatus.OK);
	}
	
	@GetMapping("/get-tiers/{idEvent}")
	private ResponseEntity<?> getEventTiers(@PathVariable("idEvent") UUID idEvent, @RequestParam(required = false, name = "page", defaultValue = "0") int page, @RequestParam(required = false, name = "size", defaultValue = "10") int size) {
		Events event = eventService.findOneByidEvent(idEvent);
		
		if (event == null) {
			return new ResponseEntity<>(new MessageDTO("Event not found"), HttpStatus.NOT_FOUND);
		}
		
		PageObjectDTO<TiersEventDTO> tiers = tiersService.getAllActiveEvents(event, page, size);
		
		return new ResponseEntity<>(tiers, HttpStatus.OK);
	}
	
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
			boolean isImage = eventService.checkIfImage(data.getCardPicture(), data.getBannerPicture());
			
			if (!isImage) {
				return new ResponseEntity<>(new MessageDTO("File uploaded it is not an image, try again"), HttpStatus.BAD_REQUEST);
			}
			
			eventService.registerEvent(data, eventCatergory, place);
			
			return new ResponseEntity<>(new MessageDTO("Event created successfully, add a Tier to activate it"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new MessageDTO("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/add-tier/{idEvent}")
	private ResponseEntity<?> getPicture(@PathVariable("idEvent") UUID idEvent, @RequestBody @Valid CreateTierDTO data, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
		}
		
		Events event = eventService.findOneByidEvent(idEvent);
		
		if (event == null) {
			return new ResponseEntity<>(new MessageDTO("Event not found"), HttpStatus.NOT_FOUND);
		}
		
		try {
			if (!event.getActive()) {
				tiersService.registerTierToEvent(event, data);
				
				return new ResponseEntity<>(new MessageDTO("Tier created and added to Event successfully, now the Event is active"), HttpStatus.OK);
			}
			
			tiersService.registerTierToEvent(event, data);
			
			return new ResponseEntity<>(new MessageDTO("Tier created and added to Event successfully"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new MessageDTO("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//PUT
	
	@PutMapping("/update/{idEvent}")
	private ResponseEntity<?> eventUpdate(@PathVariable("idEvent") UUID idEvent, @ModelAttribute UpdateEventDTO data) {
		Events event = eventService.findOneByidEvent(idEvent);
		EventCategories eventCatergory;
		Places place;
		
		if (event == null) {
			return new ResponseEntity<>(new MessageDTO("Event not found"), HttpStatus.NOT_FOUND);
		}
		
		if (data.getEventCategory() != null) {
			eventCatergory = eventCategoriesService.findEventCategoryByUUID(data.getEventCategory());
			
			if (eventCatergory == null) {
				return new ResponseEntity<>(new MessageDTO("Event category not found"), HttpStatus.NOT_FOUND);
			}
		} else {
			eventCatergory = eventCategoriesService.findEventCategoryByUUID(event.getEventCategory().getIdEventCategory());
		}
		
		if (data.getPlace() != null) {
			place = placesService.findPlaceByUUID(data.getPlace());
			
			if (place == null) {
				return new ResponseEntity<>(new MessageDTO("Place not found"), HttpStatus.NOT_FOUND);
			}
		} else {
			place = placesService.findPlaceByUUID(event.getPlace().getIdPlace());
		}
		
		try {
			if (data.getCardPicture() != null) {
				boolean isImage = eventService.checkIfImage(data.getCardPicture());
				
				if (!isImage) {
					return new ResponseEntity<>(new MessageDTO("File uploaded it is not an image, try again"), HttpStatus.BAD_REQUEST);
				}
			}
			
			if (data.getBannerPicture() != null) {
				boolean isImage = eventService.checkIfImage(data.getBannerPicture());
				
				if (!isImage) {
					return new ResponseEntity<>(new MessageDTO("File uploaded it is not an image, try again"), HttpStatus.BAD_REQUEST);
				}
			}
			
			System.out.println(eventCatergory);
			System.out.println(place);
			
			eventService.updateEvent(data, event, eventCatergory, place);
			
			if (event.getActive()) {
				return new ResponseEntity<>(new MessageDTO("Event updated successfully"), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new MessageDTO("Event updated successfully, add a Tier to activate it"), HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new MessageDTO("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//PATCH
	
	
	
	//DELETE
	
	
}