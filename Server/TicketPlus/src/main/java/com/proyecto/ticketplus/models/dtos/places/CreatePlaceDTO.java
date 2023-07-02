package com.proyecto.ticketplus.models.dtos.places;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlaceDTO {
	@NotEmpty(message = "Place name required")
	private String place;
	
	@NotEmpty(message = "Place address required")
	private String addressLocation;
}