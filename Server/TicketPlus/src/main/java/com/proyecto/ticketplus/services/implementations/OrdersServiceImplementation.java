package com.proyecto.ticketplus.services.implementations;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.models.entities.Actions;
import com.proyecto.ticketplus.models.entities.Orders;
import com.proyecto.ticketplus.repositories.IOrdersRepository;
import com.proyecto.ticketplus.services.IOrdersService;

import jakarta.transaction.Transactional;

@Service
public class OrdersServiceImplementation implements IOrdersService{
	@Autowired
	private IOrdersRepository ordersRepository;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public UUID registerOrder(Actions action) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		Orders order = new Orders(
				action,
				timestamp
				);
		
		UUID idOrder = ordersRepository.save(order).getIdOrder();
		
		return idOrder;
	}

	@Override
	public Orders findOrder(UUID idOrder) {
		return ordersRepository.findOneByidOrder(idOrder);
	}
}