package com.proyecto.ticketplus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ticketplus.models.dtos.response.MessageDTO;
import com.proyecto.ticketplus.models.dtos.users.ChangePasswordDTO;
import com.proyecto.ticketplus.models.dtos.users.LogInPasswordDTO;
import com.proyecto.ticketplus.models.entities.Users;
import com.proyecto.ticketplus.services.IUsersService;
import com.proyecto.ticketplus.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
	@Autowired
	private IUsersService userService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	//GET
	
	
	
	//POST
	
	//@PostMapping("/sign-in/google")
	//private ResponseEntity<?> signInGoogle(@ModelAttribute @Valid LogInGoogleDTO data, BindingResult validations) {
		//TODO
		//return null;
	//}
	
	@PostMapping("/sign-in/password")
	private ResponseEntity<?> signInPassword(@ModelAttribute @Valid LogInPasswordDTO data, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
		}
		
		Users user = userService.findOneByEmail(data.getEmail());
		
		if (user == null) {
			return new ResponseEntity<>(new MessageDTO("User do not exits! Make sure you have signed in with Google first"), HttpStatus.NOT_FOUND);
		}
		
		if (!user.getVerified()) {
			//TODO send email to activate account
			
			return new ResponseEntity<>(new MessageDTO("User account not verified! Make sure to verified your account first, check your email"), HttpStatus.NOT_FOUND);
		}
		
		if (!user.getActive()) {
			return new ResponseEntity<>(new MessageDTO("User account deactivated! Make sure to contact an administrator"), HttpStatus.NOT_FOUND);
		}
		
		if (user.getPassword() == null) {
			return new ResponseEntity<>(new MessageDTO("User has not set a password! Make sure you have signed in with Google first"), HttpStatus.CONFLICT);
		}
		
		Boolean validPassword = userService.comparePassword(data.getPassword(), user.getPassword());
		
		if (!validPassword) {
			return new ResponseEntity<>(new MessageDTO("Invalid credentials"), HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity<>(new MessageDTO("Logged in"), HttpStatus.OK);
	}
	
	//PUT
	
	
	
	//PATCH
	
	@PatchMapping("/sign-up/password")
	private ResponseEntity<?> signUpPassword(@ModelAttribute @Valid ChangePasswordDTO data, BindingResult validations) {
		if (validations.hasErrors()) {
			return new ResponseEntity<>(errorHandler.mapErrors(validations.getFieldErrors()), HttpStatus.BAD_REQUEST);
		}
		
		Users user = userService.findOneByEmail(data.getEmail());
		
		if (user == null) {
			return new ResponseEntity<>(new MessageDTO("User do not exits! Make sure you have signed in with Google first"), HttpStatus.NOT_FOUND);
		}
		
		if (!user.getVerified()) {
			//TODO send email to activate account
			
			return new ResponseEntity<>(new MessageDTO("User account not verified! Make sure to verify your account first"), HttpStatus.NOT_FOUND);
		}
		
		if (user.getPassword() != null) {
			return new ResponseEntity<>(new MessageDTO("User has already set a password! Make sure to sign in with your creadentials"), HttpStatus.CONFLICT);
		}
		
		if (data.getNewPassword() != data.getNewPasswordConfirm()) {
			return new ResponseEntity<>(new MessageDTO("Passwords do not match! Please re-enter your password"), HttpStatus.CONFLICT);
		}
		
		try {
			userService.signUpPassword(user, data);
			
			return new ResponseEntity<>(new MessageDTO("User updated successfully! Check your email, make sure to reactivate your account"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new MessageDTO("Internal Server Error!"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//@PatchMapping("/change-password")
	//private ResponseEntity<?> changePassword(@ModelAttribute @Valid ChangePasswordDTO data, BindingResult validations) {
		//TODO
		//return null;
	//}
	
	//DELETE
	
	
}