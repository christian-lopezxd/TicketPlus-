package com.proyecto.ticketplus.models.dtos.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserGoogleDTO {
	private String name;
	private String email;
}