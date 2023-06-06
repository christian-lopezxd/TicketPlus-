package com.proyecto.ticketplus.models.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "events_sponsor")
public class Events_sponsor {
	private UUID idEventSponsor;
	private UUID idEvent;
	private UUID idSponsor;
}