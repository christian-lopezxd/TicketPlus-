package com.proyecto.ticketplus.models.dtos.tiers;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTierDTO {
	@NotEmpty(message = "Tier name required")
	private String tier;
	
	@NotEmpty(message = "Tier price required")
	private double price;
	
	@NotEmpty(message = "Tier capacity (total people) required")
	private int capacity;
}