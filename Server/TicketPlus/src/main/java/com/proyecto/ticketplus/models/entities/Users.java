package com.proyecto.ticketplus.models.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
	private UUID idUser;
	private String idGoogle;
	private String accessToken;
	private String refreshToken;
	private String name;
	private String email;
	private String password;
	private boolean verified;
	private boolean active;
}