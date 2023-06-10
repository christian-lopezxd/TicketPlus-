package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.repositories.IEventCategoriesRepository;
import com.proyecto.ticketplus.services.IEventCategoriesService;

@Service
public class EventCategoriesServiceImplementation implements IEventCategoriesService{
	@Autowired
	private IEventCategoriesRepository eventCategoriesRepository;
}