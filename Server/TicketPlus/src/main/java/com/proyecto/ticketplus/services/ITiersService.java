package com.proyecto.ticketplus.services;

import com.proyecto.ticketplus.models.dtos.tiers.CreateTierDTO;
import com.proyecto.ticketplus.models.entities.Events;

public interface ITiersService {
	void registerTierToEvent(Events event, CreateTierDTO tier) throws Exception;
}