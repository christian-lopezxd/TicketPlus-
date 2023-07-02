package com.proyecto.ticketplus.models.dtos.event_categories;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryDTO {
	@NotEmpty(message = "Category name required")
	private String category;
}