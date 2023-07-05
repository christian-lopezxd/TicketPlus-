package com.proyecto.ticketplus.services;

import com.proyecto.ticketplus.models.entities.Actions;

public interface IActionsService {
	Actions findActionByName(String actionName);
}