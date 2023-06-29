package com.proyecto.ticketplus.services;

import com.proyecto.ticketplus.models.dtos.response.EmailDetailsDTO;

public interface IEmailService {
	//Email templates
	void sendSimpleMail(EmailDetailsDTO details);
	void sendMailWithAttachment(EmailDetailsDTO details);
    
    //Custom email
    void sendCreationEmail(String email);
    //void sendVerificationEmail(String email);
    //void sendDeactivationEmail(String email);
    //void sendSignUpEmail(String email);
    //void sendChangePasswordEmail(String email);
}