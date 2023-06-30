package com.proyecto.ticketplus.services.implementations;

import java.io.File;
import java.nio.file.Files;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.ticketplus.models.dtos.events.CreateEventDTO;
import com.proyecto.ticketplus.models.entities.EventCategories;
import com.proyecto.ticketplus.models.entities.Events;
import com.proyecto.ticketplus.models.entities.Places;
import com.proyecto.ticketplus.repositories.IEventsRepository;
import com.proyecto.ticketplus.services.IEventsService;

import jakarta.transaction.Transactional;

@Service
public class EventsServiceImplementation implements IEventsService{
	@Autowired
	private IEventsRepository eventsRepository;
	
	@Override
	public String uploadImageToFileSystem(MultipartFile file, String type) throws Exception {
		UUID uuid = UUID.randomUUID();
		String uuidAsString = uuid.toString();
		String newFileName = type + uuidAsString + "." + FilenameUtils.getExtension(file.getOriginalFilename());
		
		String oldFilePath = new PathResource("src/main/resources/static").getFile().getAbsolutePath() + File.separator + file.getOriginalFilename();
		String newFilePath = new PathResource("src/main/resources/static").getFile().getAbsolutePath() + File.separator + newFileName;
		
		File oldName = new File(oldFilePath);
		File newName = new File(newFilePath);
		
		oldName.renameTo(newName);
		
		file.transferTo(newName);
		
		return newFileName;
	}

	@Override
	public byte[] downloadImageFromFileSystem(UUID idEvent, String type) throws Exception {
		Events event = eventsRepository.findOneByidEvent(idEvent);
		
        if (type.equals("card")) {
        	String filePath = new PathResource("src/main/resources/static").getFile().getAbsolutePath() + File.separator + event.getCardPicture();
            
            return Files.readAllBytes(new File(filePath).toPath());
        }
        
        if (type.equals("banner")) {
        	String filePath = new PathResource("src/main/resources/static").getFile().getAbsolutePath() + File.separator + event.getBannerPicture();
        	
        	return Files.readAllBytes(new File(filePath).toPath());
        }
        
        return null;
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void registerEvent(CreateEventDTO event, EventCategories eventCatergory, Places place) throws Exception {
		String uploadImageCardPicture = uploadImageToFileSystem(event.getCardPicture(), "card-");
		String uploadImageBannerPicture = uploadImageToFileSystem(event.getBannerPicture(), "banner-");
		
		Events newEvent = new Events(
				eventCatergory,
				place,
				event.getTitle(),
				event.getStartDate(),
				event.getEndDate(),
				event.getQrScanStartTime(),
				event.getDescription(),
				uploadImageCardPicture,
				uploadImageBannerPicture
				);
		
		eventsRepository.save(newEvent);
	}
}