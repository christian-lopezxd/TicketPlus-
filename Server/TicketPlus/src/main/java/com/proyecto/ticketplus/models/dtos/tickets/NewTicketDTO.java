package com.proyecto.ticketplus.models.dtos.tickets;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewTicketDTO {
	@NotNull(message = "Tickets list required")
	List<NewTicketInfoDTO> tickets;
}