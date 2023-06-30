package com.proyecto.ticketplus.models.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "events")
@ToString(exclude = {"eventsInvolved", "tiers", "eventsSponsor"})
public class Events {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_event")
	private UUID idEvent;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_event_category", nullable = true)
	private EventCategories eventCategory;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_place", nullable = true)
	private Places place;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "qr_scan_start_time")
	private Date qrScanStartTime;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "card_picture")
	private String cardPicture;
	
	@Column(name = "banner_picture")
	private String bannerPicture;
	
	@Column(name = "active", insertable = false)
	private boolean active;
	
	@Column(name = "archived", insertable = false)
	private boolean archived;
	
	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<EventsInvolved> eventsInvolved;
	
	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Tiers> tiers;
	
	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<EventsSponsor> eventsSponsor;

	public Events(EventCategories eventCategory, Places place, String title, Date startDate, Date endDate, Date qrScanStartTime, String description, String cardPicture, String bannerPicture) {
		super();
		this.eventCategory = eventCategory;
		this.place = place;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.qrScanStartTime = qrScanStartTime;
		this.description = description;
		this.cardPicture = cardPicture;
		this.bannerPicture = bannerPicture;
	}
}