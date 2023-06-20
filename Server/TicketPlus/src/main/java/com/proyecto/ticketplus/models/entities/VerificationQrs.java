package com.proyecto.ticketplus.models.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "verification_qrs")
public class VerificationQrs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_verification_code")
	private UUID idVerificationCode;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ticket", nullable = true)
	private Tickets ticket;
	
	@Column(name = "qr_code")
	private String qrCode;
	
	@Column(name = "creation_date")
	private Date creationDate;
	
	@Column(name = "expiration_date")
	private Date expirationDate;
	
	public VerificationQrs(Tickets ticket, String qrCode, Date creationDate, Date expirationDate) {
		super();
		this.ticket = ticket;
		this.qrCode = qrCode;
		this.creationDate = creationDate;
		this.expirationDate = expirationDate;
	}
}