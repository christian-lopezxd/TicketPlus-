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
@Table(name = "tickets")
@ToString(exclude = {"ordersTickets", "transferQrs", "verificationQrs"})
public class Tickets {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_ticket")
	private UUID idTicket;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user", nullable = true)
	private Users user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tier", nullable = true)
	private Tiers tier;
	
	@Column(name = "purchased_date")
	private Date purchasedDate;
	
	@Column(name = "redeemed_date")
	private Date redeemed_date;
	
	@Column(name = "redeemed")
	private boolean redeemed;
	
	@OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<OrdersTicket> ordersTickets;
	
	@OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<TransferQrs> transferQrs;
	
	@OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<VerificationQrs> verificationQrs;

	public Tickets(Users user, Tiers tier, Date purchasedDate, Date redeemed_date, boolean redeemed) {
		super();
		this.user = user;
		this.tier = tier;
		this.purchasedDate = purchasedDate;
		this.redeemed_date = redeemed_date;
		this.redeemed = redeemed;
	}
}