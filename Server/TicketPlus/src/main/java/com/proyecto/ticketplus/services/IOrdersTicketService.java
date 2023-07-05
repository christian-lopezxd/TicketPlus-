package com.proyecto.ticketplus.services;

import com.proyecto.ticketplus.models.entities.Orders;
import com.proyecto.ticketplus.models.entities.Tickets;

public interface IOrdersTicketService {
	void registerOrderTicket(Orders order, Tickets ticket) throws Exception;
}