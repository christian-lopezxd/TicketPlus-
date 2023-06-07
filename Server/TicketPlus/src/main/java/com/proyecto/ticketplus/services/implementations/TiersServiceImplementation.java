package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.repositories.ITiersRepository;
import com.proyecto.ticketplus.services.ITiersService;

@Service
public class TiersServiceImplementation implements ITiersService{
	@Autowired
	private ITiersRepository tiersRepository;
}