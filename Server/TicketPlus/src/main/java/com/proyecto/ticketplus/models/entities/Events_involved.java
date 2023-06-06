package com.proyecto.ticketplus.models.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "events_involved")
public class Events_involved {
	private UUID idEventInvolved;
	private UUID idEvent;
	private UUID idInvolved;
}