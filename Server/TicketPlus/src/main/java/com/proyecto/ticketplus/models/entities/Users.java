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
@Table(name = "users")
@ToString(exclude = {"userRoles", "tickets"})
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_user")
	private UUID idUser;
	
	@Column(name = "id_google")
	private String idGoogle;
	
	@Column(name = "access_token")
	private String accessToken;
	
	@Column(name = "refresh_token")
	private String refreshToken;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@JsonIgnore
	@Column(name = "pass")
	private String password;

	@Column(name = "verified")
	private Boolean verified;
	
	@Column(name = "active")
	private Boolean active;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<UsersRoles> userRoles;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Tickets> tickets;
	
	public Users(String idGoogle, String accessToken, String refreshToken, String name, String email, String password, boolean verified, boolean active) {
		super();
		this.idGoogle = idGoogle;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.name = name;
		this.email = email;
		this.password = password;
		this.verified = verified;
		this.active = active;
	}
}