package com.proyecto.ticketplus.models.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "verification_qrs")
public class Verification_qrs {
	private UUID idVerificationCode;
	private UUID idTicket;
	private String qrCode;
	private Date creationDate;
	private Date expirationDate;
}