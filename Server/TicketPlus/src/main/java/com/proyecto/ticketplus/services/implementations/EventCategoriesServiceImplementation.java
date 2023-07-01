package com.proyecto.ticketplus.services.implementations;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.models.entities.EventCategories;
import com.proyecto.ticketplus.repositories.IEventCategoriesRepository;
import com.proyecto.ticketplus.services.IEventCategoriesService;

@Service
public class EventCategoriesServiceImplementation implements IEventCategoriesService{
	@Autowired
	private IEventCategoriesRepository eventCategoriesRepository;

	@Override
	public EventCategories findEventCategoryByUUID(UUID idEventCategory) {
		return eventCategoriesRepository.findById(idEventCategory).orElse(null);
	}
}