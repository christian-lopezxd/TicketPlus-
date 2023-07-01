package com.proyecto.ticketplus.models.dtos.users_roles;

import java.util.List;

import com.proyecto.ticketplus.models.entities.Roles;
import com.proyecto.ticketplus.models.entities.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDTO {
	private Users user;
	private List<Roles> roles;
}