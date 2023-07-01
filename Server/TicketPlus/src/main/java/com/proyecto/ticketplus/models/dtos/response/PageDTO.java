package com.proyecto.ticketplus.models.dtos.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO<T> {
	private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
}