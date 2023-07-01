package com.proyecto.ticketplus.models.dtos.events;

import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEventDTO {
	private UUID eventCategory;
	private UUID place;
	private String title;
	private Date startDate;
	private Date endDate;
	private Date qrScanStartTime;
	private String description;
	private MultipartFile cardPicture;
	private MultipartFile bannerPicture;
}