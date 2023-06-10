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
@Table(name = "actions")
@ToString(exclude = {"orders"})
public class Actions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_action")
	private UUID idAction;
	
	@Column(name = "action_name")
	private String actionName;
	
	@OneToMany(mappedBy = "action", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Orders> orders;

	public Actions(String actionName) {
		super();
		this.actionName = actionName;
	}
}