package com.proyecto.ticketplus.models.dtos.tickets;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {
	private UUID idTicket;
	private UUID idTier;
	private UUID idEvent;
	private Date purchasedDate;
	private boolean redeemed;
}