package com.proyecto.ticketplus.models.dtos.users;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInGoogleDTO {
	@NotEmpty(message = "Google token id required")
	private String idGoogleToken;
}