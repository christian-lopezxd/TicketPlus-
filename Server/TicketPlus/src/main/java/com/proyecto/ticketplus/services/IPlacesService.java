package com.proyecto.ticketplus.services;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.proyecto.ticketplus.models.dtos.places.CreatePlaceDTO;
import com.proyecto.ticketplus.models.dtos.response.PageListDTO;
import com.proyecto.ticketplus.models.entities.Places;

public interface IPlacesService {
	void RegisterPlace(CreatePlaceDTO place) throws Exception;
	Places findPlaceByUUID(UUID idPlace);
	PageListDTO<Places> generatePageable(Page<Places> events);
	List<Places> findAllPlaces();
}