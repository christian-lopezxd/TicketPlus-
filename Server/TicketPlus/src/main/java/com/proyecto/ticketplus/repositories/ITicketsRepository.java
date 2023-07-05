package com.proyecto.ticketplus.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;

import com.proyecto.ticketplus.models.entities.Tickets;
import com.proyecto.ticketplus.models.entities.Tiers;
import com.proyecto.ticketplus.models.entities.Users;

public interface ITicketsRepository extends ListCrudRepository<Tickets, UUID> {
	List<Tickets> findAllByTier(Tiers tier);
	Page<Tickets> findAllByUser(Users user, Pageable pageable);
}