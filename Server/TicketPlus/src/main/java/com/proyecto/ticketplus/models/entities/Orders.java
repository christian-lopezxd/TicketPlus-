package com.proyecto.ticketplus.models.entities;

import java.util.Date;
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
@Table(name = "orders")
@ToString(exclude = {"ordersTickets"})
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_order")
	private UUID idOrder;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_action", nullable = true)
	private Actions action;
	
	@Column(name = "action_date")
	private Date actionDate;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<OrdersTicket> ordersTickets;

	public Orders(Actions action, Date actionDate) {
		super();
		this.action = action;
		this.actionDate = actionDate;
	}
}