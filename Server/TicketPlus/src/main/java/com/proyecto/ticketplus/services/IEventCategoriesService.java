package com.proyecto.ticketplus.services;

import java.util.List;
import java.util.UUID;

import com.proyecto.ticketplus.models.dtos.event_categories.CreateCategoryDTO;
import com.proyecto.ticketplus.models.entities.EventCategories;

public interface IEventCategoriesService {
	void RegisterCategory(CreateCategoryDTO category) throws Exception;
	EventCategories findEventCategoryByUUID(UUID idCategory);
	List<EventCategories> findAllCategories();
}