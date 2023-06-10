package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.repositories.IVerificationQrsRepository;
import com.proyecto.ticketplus.services.IVerificationQrsService;

@Service
public class VerificationQrsServiceImplementation implements IVerificationQrsService {
	@Autowired
	private IVerificationQrsRepository verificationQrsRepository;
}