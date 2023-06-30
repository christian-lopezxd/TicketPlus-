package com.proyecto.ticketplus.services;

import java.util.UUID;

import com.proyecto.ticketplus.models.entities.EventCategories;

public interface IEventCategoriesService {
	public EventCategories findEventCategoryByUUID(UUID idEventCategory);
}