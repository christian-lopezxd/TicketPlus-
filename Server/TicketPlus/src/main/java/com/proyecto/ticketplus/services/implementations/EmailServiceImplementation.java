package com.proyecto.ticketplus.services.implementations;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.proyecto.ticketplus.models.dtos.response.EmailDetailsDTO;
import com.proyecto.ticketplus.services.IEmailService;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImplementation implements IEmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	 
    @Value("${spring.mail.username}")
    private String sender;
    
    @Value("${verify.frontend.url}")
    private String frontendVerifyUrl;

	@Override
	public void sendSimpleMail(EmailDetailsDTO details) {
		try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
 
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setSubject(details.getSubject());
            mailMessage.setText(details.getMsgBody());
 
            javaMailSender.send(mailMessage);
            
            System.out.println("Simple email sent successfully");
        } catch (Exception e) {
        	System.out.println("Error while sending simple email");
        	e.printStackTrace();
        }
	}

	@Override
	public void sendMailWithAttachment(EmailDetailsDTO details) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
 
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setSubject(details.getSubject());
            mimeMessageHelper.setText(details.getMsgBody());
 
            //File attachment
            File file = new ClassPathResource(details.getAttachment()).getFile();
            mimeMessageHelper.addAttachment(file.getName(), file);
 
            javaMailSender.send(mimeMessage);
            
            System.out.println("Attachment email sent successfully");
        } catch (Exception e) {
        	System.out.println("Error while sending Attachment email");
        	e.printStackTrace();
        }
	}

	@Override
	public void sendCreationEmail(String email) {
		EmailDetailsDTO emailDetails = new EmailDetailsDTO(
				email,
				"Welcome to TicketPlus+",
				"Thanks for joining our server!",
				null
				);
		
		sendSimpleMail(emailDetails);
	}

	@Override
	public void sendVerificationEmail(String email, UUID idUser) {
		EmailDetailsDTO emailDetails = new EmailDetailsDTO(
				email,
				"Verify your account",
				"Please verify your user account before you can access TicketPlus+ at: " + frontendVerifyUrl + idUser,
				null
				);
		
		sendSimpleMail(emailDetails);
	}

	@Override
	public void sendDeactivationEmail(String email, String reason) {
		EmailDetailsDTO emailDetails = new EmailDetailsDTO(
				email,
				"Account deactivated",
				"Your account at TicketPlus+ has been deactivated by an administrator; reason: " + reason,
				null
				);
		
		sendSimpleMail(emailDetails);
	}

}
