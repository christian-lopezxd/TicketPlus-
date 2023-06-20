package com.proyecto.ticketplus.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.repositories.ITransferQrsRepository;
import com.proyecto.ticketplus.services.ITransferQrsService;

@Service
public class TransferQrsServiceImplementation implements ITransferQrsService{
	@Autowired
	private ITransferQrsRepository transferQrsRepository;
}