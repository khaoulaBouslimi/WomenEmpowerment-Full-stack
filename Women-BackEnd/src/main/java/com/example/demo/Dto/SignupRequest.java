package com.example.demo.Dto;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
@Data
public class SignupRequest {

	@NotBlank
	@Size(min = 3, max = 20)
	private String username;

	@Email
	@Size(max = 51)
	private String email;

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;

	private Set<String> role;
	
	
}
