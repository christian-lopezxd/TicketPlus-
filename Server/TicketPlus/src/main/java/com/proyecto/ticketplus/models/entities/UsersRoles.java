package com.proyecto.ticketplus.models.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users_roles")
public class UsersRoles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_user_role")
	private UUID idUserRole;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user", nullable = true)
	private Users user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_role", nullable = true)
	private Roles role;

	public UsersRoles(Users user, Roles role) {
		super();
		this.user = user;
		this.role = role;
	}
}