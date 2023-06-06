package com.proyecto.ticketplus.models.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Events {
	private UUID idEvent;
	private int idEventCategory;
	private int idPlace;
	private String title;
	private Date startDate;
	private Date endDate;
	private Date qrScanStartTime;
	private String description;
	private String cardPicture;
	private String BannerPicture;
	private boolean active;
	private boolean archived;
}