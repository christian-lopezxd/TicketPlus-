package com.proyecto.ticketplus.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.proyecto.ticketplus.models.entities.Tokens;
import com.proyecto.ticketplus.models.entities.Users;

public interface ITokensRepository extends ListCrudRepository<Tokens, UUID> {
	List<Tokens> findByUserAndActive(Users user, Boolean active);
	List<Tokens> findByActive(Boolean active);
}