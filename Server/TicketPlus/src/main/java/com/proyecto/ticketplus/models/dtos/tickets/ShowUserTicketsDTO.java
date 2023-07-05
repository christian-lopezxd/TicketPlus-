package com.proyecto.ticketplus.models.dtos.tickets;

import java.util.List;

import com.proyecto.ticketplus.models.entities.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowUserTicketsDTO {
	private Users user;
	List<TicketDTO> tickets;
}