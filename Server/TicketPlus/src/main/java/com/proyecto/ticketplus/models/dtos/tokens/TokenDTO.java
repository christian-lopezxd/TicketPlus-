package com.proyecto.ticketplus.models.dtos.tokens;

import com.proyecto.ticketplus.models.entities.Tokens;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenDTO {
	private String token;
	
	public TokenDTO(Tokens token) {
		this.token = token.getContent();
	}
}