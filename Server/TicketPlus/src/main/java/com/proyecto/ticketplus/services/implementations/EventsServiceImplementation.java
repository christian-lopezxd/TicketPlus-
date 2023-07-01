package com.proyecto.ticketplus.services.implementations;

import java.io.File;
import java.nio.file.Files;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.PathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.ticketplus.models.dtos.events.CreateEventDTO;
import com.proyecto.ticketplus.models.entities.EventCategories;
import com.proyecto.ticketplus.models.entities.Events;
import com.proyecto.ticketplus.models.entities.Places;
import com.proyecto.ticketplus.repositories.IEventsRepository;
import com.proyecto.ticketplus.services.IEventsService;

import jakarta.activation.MimetypesFileTypeMap;
import jakarta.transaction.Transactional;

@Service
public class EventsServiceImplementation implements IEventsService{
	@Autowired
	private IEventsRepository eventsRepository;
	
	@Override
	public boolean checkIfImage(MultipartFile fileCard, MultipartFile fileBanner) {
		try {
			String cardFilePath = new PathResource("src/main/resources/static").getFile().getAbsolutePath() + File.separator + fileCard.getOriginalFilename();
			File cardFile = new File(cardFilePath);
			
			String cardMimeType= new MimetypesFileTypeMap().getContentType(cardFile);
	        String cardType = cardMimeType.split("/")[0];
			
			String bannerFilePath = new PathResource("src/main/resources/static").getFile().getAbsolutePath() + File.separator + fileBanner.getOriginalFilename();
	        File bannerFile = new File(bannerFilePath);
	        
	        String bannerMimeType= new MimetypesFileTypeMap().getContentType(bannerFile);
	        String bannerType = bannerMimeType.split("/")[0];
	        
	        if(!cardType.equals("image")) {
	        	return false;
	        }
	        
	        if(!bannerType.equals("image")) {
	        	return false;
	        }
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public String uploadImageToFileSystem(MultipartFile file, String type) {
		try {
			UUID uuid = UUID.randomUUID();
			String uuidAsString = uuid.toString();
			String newFileName = type + uuidAsString + "." + FilenameUtils.getExtension(file.getOriginalFilename());
			
			String oldFilePath = new PathResource("src/main/resources/static").getFile().getAbsolutePath() + File.separator + file.getOriginalFilename();
			File oldName = new File(oldFilePath);
			
			String newFilePath = new PathResource("src/main/resources/static").getFile().getAbsolutePath() + File.separator + newFileName;
			File newName = new File(newFilePath);
			
			oldName.renameTo(newName);
			
			file.transferTo(newName);
			
			return newFileName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public byte[] downloadImageFromFileSystem(String fileName) {
		try {
			String filePath = new PathResource("src/main/resources/static").getFile().getAbsolutePath() + File.separator + fileName;
	    	
	    	File file = new File(filePath);
	    	
	    	if(file.exists() && !file.isDirectory()) { 
	    		return Files.readAllBytes(file.toPath());
	    	}
	    	
	    	return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void toggleActiveEvent(Events event) throws Exception {
		if (!event.getActive()) {
			event.setActive(true);
		} else {
			event.setActive(false);
		}
		
		eventsRepository.save(event);
	}

	@Override
	public Events findOneByidEvent(UUID idEvent) {
		return eventsRepository.findOneByidEvent(idEvent);
	}

	@Override
	public Page<Events> getAllActiveEvents(int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("startDate").ascending());
		
		return eventsRepository.findAllByActive(true, pageable);
	}

	@Override
	public Page<Events> getAllEvents(int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("startDate").ascending());
		
		return eventsRepository.findAll(pageable);
	}
}