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
@Table(name = "sponsors")
@ToString(exclude = {"eventsSponsor"})
public class Sponsors {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_sponsor")
	private UUID idSponsor;
	
	@Column(name = "sponsor")
	private String sponsor;
	
	@OneToMany(mappedBy = "sponsor", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Events_sponsor> eventsSponsor;

	public Sponsors(String sponsor) {
		super();
		this.sponsor = sponsor;
	}
}