package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.repositories.IActionsRepository;
import com.proyecto.ticketplus.services.IActionsService;

@Service
public class ActionsServiceImplementation implements IActionsService{
	@Autowired
	private IActionsRepository actionsRepository;
}