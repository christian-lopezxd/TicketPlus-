package com.proyecto.ticketplus.models.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tiers")
public class Tiers {
	private UUID idTier;
	private UUID idEvent;
	private double price;
	private String tier;
	private int capacity;
}