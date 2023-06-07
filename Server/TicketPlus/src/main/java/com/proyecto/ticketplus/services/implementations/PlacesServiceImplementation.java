package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.repositories.IPlacesRepository;
import com.proyecto.ticketplus.services.IPlacesService;

@Service
public class PlacesServiceImplementation implements IPlacesService{
	@Autowired
	private IPlacesRepository placesRepository;
}