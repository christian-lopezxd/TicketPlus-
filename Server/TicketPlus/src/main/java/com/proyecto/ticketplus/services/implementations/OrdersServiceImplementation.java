package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.repositories.IOrdersRepository;
import com.proyecto.ticketplus.services.IOrdersService;

@Service
public class OrdersServiceImplementation implements IOrdersService{
	@Autowired
	private IOrdersRepository ordersRepository;
}