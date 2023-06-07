package com.proyecto.ticketplus.models.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "events_sponsor")
public class EventsSponsor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_event_sponsor")
	private UUID idEventSponsor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_event", nullable = true)
	private Events event;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sponsor", nullable = true)
	private Sponsors sponsor;

	public EventsSponsor(Events event, Sponsors sponsor) {
		super();
		this.event = event;
		this.sponsor = sponsor;
	}
}