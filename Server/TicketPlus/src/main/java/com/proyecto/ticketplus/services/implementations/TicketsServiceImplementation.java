package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.repositories.ITicketsRepository;
import com.proyecto.ticketplus.services.ITicketsService;

@Service
public class TicketsServiceImplementation implements ITicketsService{
	@Autowired
	private ITicketsRepository ticketsServiceRepository;
}