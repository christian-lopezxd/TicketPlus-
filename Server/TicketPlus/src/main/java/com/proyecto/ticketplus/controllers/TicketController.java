package com.proyecto.ticketplus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ticketplus.models.dtos.response.MessageDTO;
import com.proyecto.ticketplus.models.dtos.response.PageObjectDTO;
import com.proyecto.ticketplus.models.dtos.tickets.NewTicketDTO;
import com.proyecto.ticketplus.models.dtos.tickets.ShowUserTicketsDTO;
import com.proyecto.ticketplus.models.entities.Tiers;
import com.proyecto.ticketplus.models.entities.Users;
import com.proyecto.ticketplus.services.ITicketsService;
import com.proyecto.ticketplus.services.ITiersService;
import com.proyecto.ticketplus.services.IUsersService;
import com.proyecto.ticketplus.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ticket")
@CrossOrigin("*")
public class TicketController {
	@Autowired
	private ITicketsService ticketsService;
	
	@Autowired
	private IUsersService userService;
	
	@Autowired
	private ITiersService tiersService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	//GET
	
	@GetMapping("/get-all")
	private ResponseEntity<?> getEvents(@RequestParam(required = false, name = "page", defaultValue = "0") int page, @RequestParam(required = false, name = "size", defaultValue = "10") int size) {
		Users user = userService.findUserAuthenticated();
		
		PageObjectDTO<ShowUserTicketsDTO> tickets = ticketsService.getAllTickets(user, page, size);
		
		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}
	
	//POST
	
	@PostMapping("/create")
	private ResponseEntity<?> eventCreate(@RequestBody @Valid NewTicketDTO data, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
		}
		
		Users user = userService.findUserAuthenticated();
		
		if (user == null) {
			return new ResponseEntity<>(new MessageDTO("User not found"), HttpStatus.NOT_FOUND);
		}
		
		for (int i = 0; i < data.getTickets().size(); i++) {
			Tiers tier = tiersService.findfindOneByidTier(data.getTickets().get(i).getIdTier());
			
			if (tier == null) {
				return new ResponseEntity<>(new MessageDTO("Tier '" + data.getTickets().get(i).getIdTier() + "' not found"), HttpStatus.NOT_FOUND);
			}
			
			int soldTickets = ticketsService.countTicketsWithSameTier(tier);
			
			if (data.getTickets().get(i).getQuantity() > (tier.getCapacity() - soldTickets)) {
				
				return new ResponseEntity<>(new MessageDTO("You are trying to buy more tickets than the ones available in '" + tier.getTier() + "', just " + (tier.getCapacity() - soldTickets) + " tickets left"), HttpStatus.CONFLICT);
			}
		}
		
		try {
			ticketsService.registerTicket(user, data);
			
			return new ResponseEntity<>(new MessageDTO("Tickets purchased successfully"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new MessageDTO("Internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//PUT
	
	
	
	//PATCH
	
	
	
	//DELETE
	
	
}