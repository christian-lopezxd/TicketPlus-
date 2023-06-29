package com.proyecto.ticketplus.services;

import java.util.UUID;

import com.proyecto.ticketplus.models.dtos.response.EmailDetailsDTO;

public interface IEmailService {
	//Email templates
	void sendSimpleMail(EmailDetailsDTO details);
	void sendMailWithAttachment(EmailDetailsDTO details);
    
    //Custom email
    void sendCreationEmail(String email);
    void sendVerificationEmail(String email, UUID idUser);
    void sendDeactivationEmail(String email, String reason);
    //void sendSignUpEmail(String email);
    //void sendChangePasswordEmail(String email);
}