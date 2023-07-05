package com.proyecto.ticketplus.models.dtos.tickets;

import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {
	@NotNull(message = "Tier identifier required")
	private UUID idTier;
	
	@Min(value = 1, message = "Total tickets required, must be positive and greater than 1")
	private int quantity;
}