package com.proyecto.ticketplus.services;

import org.springframework.data.domain.Page;

import com.proyecto.ticketplus.models.dtos.response.PageObjectDTO;
import com.proyecto.ticketplus.models.dtos.tiers.CreateTierDTO;
import com.proyecto.ticketplus.models.dtos.tiers.TiersEventDTO;
import com.proyecto.ticketplus.models.entities.Events;
import com.proyecto.ticketplus.models.entities.Tiers;

public interface ITiersService {
	void registerTierToEvent(Events event, CreateTierDTO tier) throws Exception;
	PageObjectDTO<TiersEventDTO> generatePageable(Page<Tiers> tiers);
	PageObjectDTO<TiersEventDTO> getAllActiveEvents(Events event, int page, int size);
}