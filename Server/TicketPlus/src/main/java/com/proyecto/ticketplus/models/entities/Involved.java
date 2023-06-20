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
@Table(name = "involved")
@ToString(exclude = {"eventsInvolved"})
public class Involved {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_involved")
	private UUID idInvolved;
	
	@Column(name = "involved")
	private String involved;
	
	@OneToMany(mappedBy = "involved", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<EventsInvolved> eventsInvolved;

	public Involved(String involved) {
		super();
		this.involved = involved;
	}
}