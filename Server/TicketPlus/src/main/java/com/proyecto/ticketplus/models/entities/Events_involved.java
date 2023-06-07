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
@Table(name = "events_involved")
public class Events_involved {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_event_involved")
	private UUID idEventInvolved;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_event", nullable = true)
	private Events event;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_involved", nullable = true)
	private Involved involved;
}