package com.proyecto.ticketplus.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.proyecto.ticketplus.models.entities.Tickets;
import com.proyecto.ticketplus.models.entities.Tiers;

public interface ITicketsRepository extends ListCrudRepository<Tickets, UUID> {
	List<Tickets> findAllByTier(Tiers tier);
}