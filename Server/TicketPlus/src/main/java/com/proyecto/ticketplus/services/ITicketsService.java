package com.proyecto.ticketplus.services;

import org.springframework.data.domain.Page;

import com.proyecto.ticketplus.models.dtos.response.PageObjectDTO;
import com.proyecto.ticketplus.models.dtos.tickets.NewTicketDTO;
import com.proyecto.ticketplus.models.dtos.tickets.ShowUserTicketsDTO;
import com.proyecto.ticketplus.models.entities.Tickets;
import com.proyecto.ticketplus.models.entities.Tiers;
import com.proyecto.ticketplus.models.entities.Users;

public interface ITicketsService {
	int countTicketsWithSameTier(Tiers tier);
	void registerTicket(Users user, NewTicketDTO data);
	PageObjectDTO<ShowUserTicketsDTO> generatePageable(Page<Tickets> tickets);
	PageObjectDTO<ShowUserTicketsDTO> getAllTickets(Users user, int page, int size);
}