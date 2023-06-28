package com.proyecto.ticketplus.models.dtos.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInPasswordDTO {
	@NotEmpty(message = "Email required")
	@Email(message = "Email format not valid")
	private String email;
	
	@NotEmpty(message = "Password required")
	@Pattern(regexp = "(?=[A-Za-z0-9@#$%^&+!=]+$)^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+!=])(?=.{8,}).*$", message = "Password must be 8 digits length containing at least 1 uppercase, 1 lowercase, 1 special character and 1 digit")
	private String password;
}