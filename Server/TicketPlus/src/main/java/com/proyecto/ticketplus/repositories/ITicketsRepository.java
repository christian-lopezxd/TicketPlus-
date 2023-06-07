package com.proyecto.ticketplus.repositories;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.proyecto.ticketplus.models.entities.Tickets;

public interface ITicketsRepository extends ListCrudRepository<Tickets, UUID> {

}
