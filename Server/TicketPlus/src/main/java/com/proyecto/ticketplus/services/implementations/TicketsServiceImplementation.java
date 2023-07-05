package com.proyecto.ticketplus.services.implementations;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.models.dtos.response.PageObjectDTO;
import com.proyecto.ticketplus.models.dtos.tickets.NewTicketDTO;
import com.proyecto.ticketplus.models.dtos.tickets.ShowUserTicketsDTO;
import com.proyecto.ticketplus.models.dtos.tickets.TicketDTO;
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
	
	@Override
	public PageObjectDTO<ShowUserTicketsDTO> generatePageable(Page<Tickets> tickets) {
		List<TicketDTO> newTicketDTO = new ArrayList<TicketDTO>();
		
		for (int i = 0; i < tickets.getContent().size(); i++) {
			TicketDTO tempTicketDTO = new TicketDTO(
					tickets.getContent().get(i).getIdTicket(),
					tickets.getContent().get(i).getTier().getIdTier(),
					tickets.getContent().get(i).getTier().getEvent().getIdEvent(),
					tickets.getContent().get(i).getPurchasedDate(),
					tickets.getContent().get(i).isRedeemed()
					);
			
			newTicketDTO.add(tempTicketDTO);
		}
		
		ShowUserTicketsDTO showTickets = new ShowUserTicketsDTO(
				tickets.getContent().get(0).getUser(),
				newTicketDTO
				);
		
		PageObjectDTO<ShowUserTicketsDTO> ticketsDTO = new PageObjectDTO<ShowUserTicketsDTO>(
				showTickets,
				tickets.getNumber(),
				tickets.getSize(),
				tickets.getTotalElements(),
				tickets.getTotalPages()
				);
		
		return ticketsDTO;
	}

	@Override
	public PageObjectDTO<ShowUserTicketsDTO> getAllTickets(Users user, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Tickets> tickets = ticketsServiceRepository.findAllByUser(user, pageable);

		PageObjectDTO<ShowUserTicketsDTO> ticketsPageable = generatePageable(tickets);
		
		return ticketsPageable;
	}
}