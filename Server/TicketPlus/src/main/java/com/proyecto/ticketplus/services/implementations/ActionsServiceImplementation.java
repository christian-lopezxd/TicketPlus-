package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.models.entities.Actions;
import com.proyecto.ticketplus.repositories.IActionsRepository;
import com.proyecto.ticketplus.services.IActionsService;

@Service
public class ActionsServiceImplementation implements IActionsService{
	@Autowired
	private IActionsRepository actionsRepository;

	@Override
	public Actions findActionByName(String actionName) {
		return actionsRepository.findOneByactionName(actionName);
	}
}