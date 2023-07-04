package com.proyecto.ticketplus.models.dtos.users_roles;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserRoleDTO {
	@NotNull(message = "User identifier required")
	private UUID idUser;
	
	@NotNull(message = "Role identifier required")
	private UUID idRole;
}