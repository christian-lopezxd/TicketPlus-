package com.proyecto.ticketplus.services.implementations;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.models.entities.Places;
import com.proyecto.ticketplus.repositories.IPlacesRepository;
import com.proyecto.ticketplus.services.IPlacesService;

@Service
public class PlacesServiceImplementation implements IPlacesService{
	@Autowired
	private IPlacesRepository placesRepository;

	@Override
	public Places findPlaceByUUID(UUID idPlace) {
		return placesRepository.findById(idPlace).orElse(null);
	}
}