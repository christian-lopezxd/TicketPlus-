package com.proyecto.ticketplus.repositories;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.proyecto.ticketplus.models.entities.Sponsors;

public interface ISponsorsRepository extends ListCrudRepository<Sponsors, UUID> {

}
