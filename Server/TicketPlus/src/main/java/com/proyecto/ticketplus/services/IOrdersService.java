package com.proyecto.ticketplus.services;

import java.util.UUID;

import com.proyecto.ticketplus.models.entities.Actions;
import com.proyecto.ticketplus.models.entities.Orders;

public interface IOrdersService {
	UUID registerOrder(Actions action) throws Exception;
	Orders findOrder(UUID idOrder);
}