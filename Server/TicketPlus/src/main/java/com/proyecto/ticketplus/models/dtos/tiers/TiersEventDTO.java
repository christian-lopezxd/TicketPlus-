package com.proyecto.ticketplus.models.dtos.tiers;

import java.util.List;

import com.proyecto.ticketplus.models.entities.Events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TiersEventDTO {
	private Events event;
	private int totalEventCapacity;
	private List<TierDTO> tiers;
}