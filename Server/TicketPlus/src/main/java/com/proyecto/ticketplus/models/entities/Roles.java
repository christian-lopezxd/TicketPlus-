package com.proyecto.ticketplus.models.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "roles")
@ToString(exclude = {"userRoles"})
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_role")
	private UUID idRole;
	
	@Column(name = "rol")
	private String Role;
	
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Users_roles> userRoles;

	public Roles(String role) {
		super();
		Role = role;
	}
}