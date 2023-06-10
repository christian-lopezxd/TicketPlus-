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
@Table(name = "places")
@ToString(exclude = {"events"})
public class Places {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_place")
	private UUID idPlace;
	
	@Column(name = "place")
	private String place;
	
	@Column(name = "address_location")
	private String addressLocation;
	
	@OneToMany(mappedBy = "place", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Events> events;

	public Places(String place, String addressLocation) {
		super();
		this.place = place;
		this.addressLocation = addressLocation;
	}
}