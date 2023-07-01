package com.proyecto.ticketplus.services;

import java.util.UUID;

import com.proyecto.ticketplus.models.entities.Places;

public interface IPlacesService {
	public Places findPlaceByUUID(UUID idPlace);
}