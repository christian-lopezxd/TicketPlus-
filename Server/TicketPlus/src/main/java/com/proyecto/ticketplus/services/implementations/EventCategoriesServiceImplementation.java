package com.proyecto.ticketplus.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.models.dtos.event_categories.CreateCategoryDTO;
import com.proyecto.ticketplus.models.entities.EventCategories;
import com.proyecto.ticketplus.repositories.IEventCategoriesRepository;
import com.proyecto.ticketplus.services.IEventCategoriesService;

import jakarta.transaction.Transactional;

@Service
public class EventCategoriesServiceImplementation implements IEventCategoriesService{
	@Autowired
	private IEventCategoriesRepository eventCategoriesRepository;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void RegisterCategory(CreateCategoryDTO category) throws Exception {
		EventCategories newCategory = new EventCategories(
				category.getCategory()
				);
		
		eventCategoriesRepository.save(newCategory);
	}
	
	@Override
	public EventCategories findEventCategoryByUUID(UUID idCategory) {
		return eventCategoriesRepository.findById(idCategory).orElse(null);
	}
	
	@Override
	public List<EventCategories> findAllCategories() {
		return eventCategoriesRepository.findAll();
	}
}