package com.proyecto.ticketplus.models.dtos.users;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeactivationDTO {
	@NotEmpty(message = "Deactivation reason required")
	private String reason;
}