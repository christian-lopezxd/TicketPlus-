package com.proyecto.ticketplus.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.models.dtos.places.CreatePlaceDTO;
import com.proyecto.ticketplus.models.dtos.response.PageListDTO;
import com.proyecto.ticketplus.models.entities.Places;
import com.proyecto.ticketplus.repositories.IPlacesRepository;
import com.proyecto.ticketplus.services.IPlacesService;

import jakarta.transaction.Transactional;

@Service
public class PlacesServiceImplementation implements IPlacesService{
	@Autowired
	private IPlacesRepository placesRepository;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void RegisterPlace(CreatePlaceDTO place) throws Exception {
		Places newPlace = new Places(
				place.getPlace(),
				place.getAddressLocation()
				);
		
		placesRepository.save(newPlace);
	}
	
	@Override
	public Places findPlaceByUUID(UUID idPlace) {
		return placesRepository.findById(idPlace).orElse(null);
	}
	
	@Override
	public PageListDTO<Places> generatePageable(Page<Places> places) {
		PageListDTO<Places> eventsPageable = new PageListDTO<>(
				places.getContent(),
				places.getNumber(),
				places.getSize(),
				places.getTotalElements(),
				places.getTotalPages()
				);
		
		return eventsPageable;
	}

	@Override
	public List<Places> findAllPlaces() {
		return placesRepository.findAll();
	}
}