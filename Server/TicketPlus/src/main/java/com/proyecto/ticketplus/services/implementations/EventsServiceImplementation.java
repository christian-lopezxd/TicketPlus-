package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.repositories.IEventsRepository;
import com.proyecto.ticketplus.services.IEventsService;

@Service
public class EventsServiceImplementation implements IEventsService{
	@Autowired
	private IEventsRepository eventsRepository;
}