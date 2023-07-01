package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.models.dtos.tiers.CreateTierDTO;
import com.proyecto.ticketplus.models.entities.Events;
import com.proyecto.ticketplus.models.entities.Tiers;
import com.proyecto.ticketplus.repositories.ITiersRepository;
import com.proyecto.ticketplus.services.IEventsService;
import com.proyecto.ticketplus.services.ITiersService;

import jakarta.transaction.Transactional;

@Service
public class TiersServiceImplementation implements ITiersService{
	@Autowired
	private ITiersRepository tiersRepository;
	
	@Autowired
	private IEventsService eventService;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void registerTierToEvent(Events event, CreateTierDTO tier) throws Exception {
		if (!event.getActive()) {
			eventService.toggleActiveEvent(event);
		}
		
		Tiers newTier = new Tiers(
				event,
				tier.getPrice(),
				tier.getTier(),
				tier.getCapacity()
				);
		
		tiersRepository.save(newTier);
	}
}