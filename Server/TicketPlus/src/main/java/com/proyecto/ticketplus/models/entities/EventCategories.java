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
@Table(name = "event_categories")
@ToString(exclude = {"events"})
public class EventCategories {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_event_category")
	private UUID idEventCategory;
	
	@Column(name = "event_category")
	private String eventCategoryName;
	
	@OneToMany(mappedBy = "eventCategory", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Events> events;

	public EventCategories(String eventCategory) {
		super();
		this.eventCategoryName = eventCategory;
	}
}