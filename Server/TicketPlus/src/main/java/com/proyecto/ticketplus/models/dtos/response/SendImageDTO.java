package com.proyecto.ticketplus.models.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SendImageDTO {
	private byte[] image;
}