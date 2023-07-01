package com.proyecto.ticketplus.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.ticketplus.models.entities.Events;

public interface IEventsRepository extends JpaRepository<Events, UUID> {
	Events findOneByidEvent(UUID idEvent);
	Page<Events> findAllByActiveAndArchived(Boolean active, Boolean archived, Pageable pageable);
}