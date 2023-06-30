package com.proyecto.ticketplus.models.dtos.events;

import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventDTO {
	@NotNull (message = "Event category UUID required")
	private UUID eventCategory;
	
	@NotNull (message = "Place UUID required")
	private UUID place;
	
	@NotEmpty(message = "Title required")
	private String title;
	
	@NotNull (message = "Event start date required")
	private Date startDate;
	
	@NotNull (message = "Event end date required")
	private Date endDate;
	
	@NotNull (message = "Event QR scan start time required")
	private Date qrScanStartTime;
	
	@NotEmpty(message = "Event description required")
	private String description;
	
	@NotNull(message = "Event card picture required")
	private MultipartFile cardPicture;
	
	@NotNull(message = "Event banner picture required")
	private MultipartFile bannerPicture;
	
	//@NotEmpty(message = "Event tier/s required")
	//private List<CreateTierDTO> tier;
}