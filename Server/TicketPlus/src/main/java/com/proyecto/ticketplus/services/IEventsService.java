package com.proyecto.ticketplus.services;

import org.springframework.web.multipart.MultipartFile;

import com.proyecto.ticketplus.models.dtos.events.CreateEventDTO;
import com.proyecto.ticketplus.models.entities.EventCategories;
import com.proyecto.ticketplus.models.entities.Places;

public interface IEventsService {
	boolean checkIfImage(MultipartFile fileCard, MultipartFile fileBanner);
	String uploadImageToFileSystem(MultipartFile file, String type);
	byte[] downloadImageFromFileSystem(String fileName);
	void registerEvent(CreateEventDTO event, EventCategories eventCatergory, Places place) throws Exception;;
}