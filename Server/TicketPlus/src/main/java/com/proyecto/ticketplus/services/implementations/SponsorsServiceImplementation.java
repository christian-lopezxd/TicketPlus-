package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.repositories.ISponsorsRepository;
import com.proyecto.ticketplus.services.ISponsorsService;

@Service
public class SponsorsServiceImplementation implements ISponsorsService{
	@Autowired
	private ISponsorsRepository sponsorsRepository;
}