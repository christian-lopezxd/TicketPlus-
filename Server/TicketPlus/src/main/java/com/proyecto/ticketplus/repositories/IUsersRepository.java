package com.proyecto.ticketplus.repositories;

import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.proyecto.ticketplus.models.entities.Users;

public interface IUsersRepository extends ListCrudRepository<Users, UUID> {

}
