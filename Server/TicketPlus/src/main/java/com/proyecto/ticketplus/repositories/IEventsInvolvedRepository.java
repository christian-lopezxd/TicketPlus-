package com.proyecto.ticketplus.repositories;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.proyecto.ticketplus.models.entities.EventsInvolved;

public interface IEventsInvolvedRepository extends ListCrudRepository<EventsInvolved, UUID> {

}
