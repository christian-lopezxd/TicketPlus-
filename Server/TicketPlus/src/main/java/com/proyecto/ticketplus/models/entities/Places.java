package com.proyecto.ticketplus.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "places")
public class Places {
	private int idPlace;
	private String place;
	private String addressLocation;
}