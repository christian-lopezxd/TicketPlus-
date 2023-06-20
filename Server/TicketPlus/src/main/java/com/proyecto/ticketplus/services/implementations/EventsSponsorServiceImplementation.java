package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.repositories.IEventsSponsorRepository;
import com.proyecto.ticketplus.services.IEventsSponsorService;

@Service
public class EventsSponsorServiceImplementation implements IEventsSponsorService{
	@Autowired
	private IEventsSponsorRepository eventsSponsorRepository;
}