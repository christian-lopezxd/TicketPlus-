package com.proyecto.ticketplus.services;

import com.proyecto.ticketplus.models.dtos.response.EmailDetailsDTO;

public interface IEmailService {
	//Email templates
	void sendSimpleMail(EmailDetailsDTO details);
	void sendMailWithAttachment(EmailDetailsDTO details);
    
    //Custom email
    //void sendCreationEmail();
    //void sendVerificationEmail();
    //void sendDeactivationEmail();
    //void sendSignUpEmail();
    //void sendChangePasswordEmail();
}