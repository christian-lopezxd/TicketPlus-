package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.repositories.IInvolvedRepository;
import com.proyecto.ticketplus.services.IInvolvedService;

@Service
public class InvolvedServiceImplementation implements IInvolvedService{
	@Autowired
	private  IInvolvedRepository  involvedServiceRepository;
}