package com.proyecto.ticketplus.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.models.dtos.response.PageObjectDTO;
import com.proyecto.ticketplus.models.dtos.tiers.CreateTierDTO;
import com.proyecto.ticketplus.models.dtos.tiers.TierDTO;
import com.proyecto.ticketplus.models.dtos.tiers.TiersEventDTO;
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

	@Override
	public PageObjectDTO<TiersEventDTO> generatePageable(Page<Tiers> tiers) {
		TiersEventDTO tiersEvents = new TiersEventDTO();
		List<TierDTO> tiersList = new ArrayList<TierDTO>();
		int totalEventCapacity = 0;
		
		for (int i = 0; i < tiers.getContent().size(); i++) {
			totalEventCapacity += tiers.getContent().get(i).getCapacity();
			
			TierDTO tierTemp = new TierDTO(
					tiers.getContent().get(i).getIdTier(),
					tiers.getContent().get(i).getTier(),
					tiers.getContent().get(i).getPrice(),
					tiers.getContent().get(i).getCapacity()
					);
			
			tiersList.add(tierTemp);
		}
		
		if (tiers.getContent().size() > 0) {
			tiersEvents.setEvent(tiers.getContent().get(0).getEvent());
			tiersEvents.setTotalEventCapacity(totalEventCapacity);
			tiersEvents.setTiers(tiersList);
		}
		
		PageObjectDTO<TiersEventDTO> tiersPageable = new PageObjectDTO<>(
				tiersEvents,
				tiers.getNumber(),
				tiers.getSize(),
				tiers.getTotalElements(),
				tiers.getTotalPages()
				);
		
		return tiersPageable;
	}

	@Override
	public PageObjectDTO<TiersEventDTO> getAllActiveEvents(Events event, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Tiers> tiers = tiersRepository.findAllByEvent(event, pageable);

		PageObjectDTO<TiersEventDTO> tiersPageable = generatePageable(tiers);
		
		return tiersPageable;
	}
}