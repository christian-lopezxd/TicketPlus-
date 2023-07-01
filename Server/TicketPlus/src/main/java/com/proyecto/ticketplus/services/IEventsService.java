package com.proyecto.ticketplus.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.ticketplus.models.dtos.events.CreateEventDTO;
import com.proyecto.ticketplus.models.dtos.response.PageListDTO;
import com.proyecto.ticketplus.models.entities.EventCategories;
import com.proyecto.ticketplus.models.entities.Events;
import com.proyecto.ticketplus.models.entities.Places;

public interface IEventsService {
	boolean checkIfImage(MultipartFile fileCard, MultipartFile fileBanner);
	String uploadImageToFileSystem(MultipartFile file, String type);
	byte[] downloadImageFromFileSystem(String fileName);
	void registerEvent(CreateEventDTO event, EventCategories eventCatergory, Places place) throws Exception;
	void toggleActiveEvent(Events event) throws Exception;
	Events findOneByidEvent(UUID idEvent);
	PageListDTO<Events> generatePageable(Page<Events> events);
	PageListDTO<Events> getAllActiveEvents(int page, int size);
	PageListDTO<Events> getAllEvents(int page, int size);
}