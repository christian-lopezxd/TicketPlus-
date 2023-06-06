package com.proyecto.ticketplus.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "actions")
public class Actions {
	private int idAction;
	private String actionName;
}