package com.proyecto.ticketplus.models.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetailsDTO {
	private String recipient;
	private String subject;
    private String msgBody;
    private String attachment;
}