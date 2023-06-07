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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tiers")
@ToString(exclude = {"tickets"})
public class Tiers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tier")
	private UUID idTier;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_event", nullable = true)
	private Events event;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "tier")
	private String tier;
	
	@Column(name = "capacity")
	private int capacity;
	
	@OneToMany(mappedBy = "tier", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Tickets> tickets;

	public Tiers(Events event, double price, String tier, int capacity) {
		super();
		this.event = event;
		this.price = price;
		this.tier = tier;
		this.capacity = capacity;
	}
}