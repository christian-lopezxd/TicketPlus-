package com.proyecto.ticketplus.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.ticketplus.models.entities.Events;
import com.proyecto.ticketplus.models.entities.Tiers;

public interface ITiersRepository extends JpaRepository<Tiers, UUID> {
	Tiers findOneByidTier(UUID idTier);
	Page<Tiers> findAllByEvent(Events event, Pageable pageable);
}