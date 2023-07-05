package com.proyecto.ticketplus.services;

import com.proyecto.ticketplus.models.dtos.tickets.NewTicketDTO;
import com.proyecto.ticketplus.models.entities.Tiers;
import com.proyecto.ticketplus.models.entities.Users;

public interface ITicketsService {
	int countTicketsWithSameTier(Tiers tier);
	void registerTicket(Users user, NewTicketDTO data);
}