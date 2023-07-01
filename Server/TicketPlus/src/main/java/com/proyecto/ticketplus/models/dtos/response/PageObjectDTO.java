package com.proyecto.ticketplus.models.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageObjectDTO<T> {
	private Object content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
}