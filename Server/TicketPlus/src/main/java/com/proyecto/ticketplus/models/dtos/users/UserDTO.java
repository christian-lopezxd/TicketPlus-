package com.proyecto.ticketplus.models.dtos.users;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private UUID idUser;
	private String name;
	private String email;
	private Boolean verified;
	private Boolean active;
}