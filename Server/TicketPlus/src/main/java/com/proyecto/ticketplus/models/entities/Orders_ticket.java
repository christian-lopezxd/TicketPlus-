package com.proyecto.ticketplus.models.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders_ticket")
public class Orders_ticket {
	private UUID idOrderTicket;
	private UUID idOrder;
	private UUID idTicket;
}