package com.proyecto.ticketplus.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.ticketplus.models.entities.Places;

public interface IPlacesRepository extends JpaRepository<Places, UUID> {
	Page<Places> findAll(Pageable pageable);
}