package com.proyecto.ticketplus.models.dtos.tiers;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTierDTO {
	@NotEmpty(message = "Tier name required")
	private String tier;
	
	@PositiveOrZero(message = "Tier price required, must be positive")
	private double price;
	
	@Min(value = 1, message = "Tier capacity (total people) required, must be positive and greater than 1")
	private int capacity;
}