package com.proyecto.ticketplus.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "event_categories")
public class Event_categories {
	private int idEventCategory;
	private String eventCategory;
}