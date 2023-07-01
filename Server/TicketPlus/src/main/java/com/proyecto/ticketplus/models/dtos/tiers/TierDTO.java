package com.proyecto.ticketplus.models.dtos.tiers;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TierDTO {
	private UUID idTier;
	private String tier;
	private double price;
	private int capacity;
}