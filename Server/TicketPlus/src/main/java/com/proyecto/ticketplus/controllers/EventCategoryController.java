package com.proyecto.ticketplus.controllers;

import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ticketplus.models.dtos.event_categories.CreateCategoryDTO;
import com.proyecto.ticketplus.models.dtos.response.MessageDTO;
import com.proyecto.ticketplus.models.entities.EventCategories;
import com.proyecto.ticketplus.services.IEventCategoriesService;
import com.proyecto.ticketplus.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class EventCategoryController {
	@Autowired
	private IEventCategoriesService eventCategoriesService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	//GET
	
	@GetMapping("/get-all")
	private ResponseEntity<?> getCategories() {
		List<EventCategories> categories = eventCategoriesService.findAllCategories();
		
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@GetMapping("/get-one/{idCategory}")
	private ResponseEntity<?> getCategory(@PathVariable("idCategory") UUID idCategory) {
		EventCategories category = eventCategoriesService.findEventCategoryByUUID(idCategory);
		
		if (category == null) {
			return new ResponseEntity<>(new MessageDTO("Category not found"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(category, HttpStatus.OK);
	}
	
	//POST
	
	@PostMapping("/create")
	private ResponseEntity<?> createCategory(@RequestBody @Valid CreateCategoryDTO data, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
		}
		
		try {
			eventCategoriesService.RegisterCategory(data);
			
			return new ResponseEntity<>(new MessageDTO("Category added successfully"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new MessageDTO("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//PUT
	
	
	
	//PATCH
	
	
	
	//DELETE
	
	
}