package com.proyecto.ticketplus.models.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders_ticket")
public class OrdersTicket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_order_ticket")
	private UUID idOrderTicket;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_order", nullable = true)
	private Orders order;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ticket", nullable = true)
	private Tickets ticket;

	public OrdersTicket(Orders order, Tickets ticket) {
		super();
		this.order = order;
		this.ticket = ticket;
	}
}