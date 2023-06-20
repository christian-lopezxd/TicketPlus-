package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.repositories.IEventsInvolvedRepository;
import com.proyecto.ticketplus.services.IEventsInvolvedService;

@Service
public class EventsInvolvedServiceImplementation implements IEventsInvolvedService{
	@Autowired
	private IEventsInvolvedRepository eventsInvolvedRepository;
}