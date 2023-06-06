package com.proyecto.ticketplus.models.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users_roles")
public class Users_roles {
	private UUID idUserRole;
	private UUID idUser;
	private int idRole;
}