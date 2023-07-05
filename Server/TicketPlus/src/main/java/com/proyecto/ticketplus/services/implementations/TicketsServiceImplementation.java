package com.proyecto.ticketplus.services.implementations;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.models.dtos.tickets.NewTicketDTO;
import com.proyecto.ticketplus.models.entities.Tickets;
import com.proyecto.ticketplus.models.entities.Tiers;
import com.proyecto.ticketplus.models.entities.Users;
import com.proyecto.ticketplus.repositories.ITicketsRepository;
import com.proyecto.ticketplus.services.ITicketsService;
import com.proyecto.ticketplus.services.ITiersService;

@Service
public class TicketsServiceImplementation implements ITicketsService{
	@Autowired
	private ITicketsRepository ticketsServiceRepository;
	
	@Autowired
	private ITiersService tiersService;

	@Override
	public int countTicketsWithSameTier(Tiers tier) {
		return ticketsServiceRepository.findAllByTier(tier).size();
	}

	@Override
	public void registerTicket(Users user, NewTicketDTO data) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		for (int i = 0; i < data.getTickets().size(); i++) {
			Tiers tier = tiersService.findfindOneByidTier(data.getTickets().get(i).getIdTier());
			
			for (int j = 1; j <= data.getTickets().get(i).getQuantity(); j++) {
				Tickets newTicket = new Tickets(
						user,
						tier,
						timestamp,
						null,
						false
						);
				
				ticketsServiceRepository.save(newTicket);
			}
		}
	}
}