package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.repositories.IOrdersTicketRepository;
import com.proyecto.ticketplus.services.IOrdersTicketService;

@Service
public class OrdersTicketServiceImplementation implements IOrdersTicketService{
	@Autowired
	private IOrdersTicketRepository ordersTicketRepository;
}