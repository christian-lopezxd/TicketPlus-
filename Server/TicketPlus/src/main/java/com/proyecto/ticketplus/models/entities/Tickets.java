package com.proyecto.ticketplus.models.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class Tickets {
	private UUID idTicket;
	private UUID idUser;
	private UUID idTier;
	private Date purchasedDate;
	private Date redeemed_date;
	private boolean redeemed;
}