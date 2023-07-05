package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.models.entities.Orders;
import com.proyecto.ticketplus.models.entities.OrdersTicket;
import com.proyecto.ticketplus.models.entities.Tickets;
import com.proyecto.ticketplus.repositories.IOrdersTicketRepository;
import com.proyecto.ticketplus.services.IOrdersTicketService;

import jakarta.transaction.Transactional;

@Service
public class OrdersTicketServiceImplementation implements IOrdersTicketService{
	@Autowired
	private IOrdersTicketRepository ordersTicketRepository;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void registerOrderTicket(Orders order, Tickets ticket) throws Exception {
		OrdersTicket orderTicket = new OrdersTicket(
				order,
				ticket
				);
		
		ordersTicketRepository.save(orderTicket);
	}
}