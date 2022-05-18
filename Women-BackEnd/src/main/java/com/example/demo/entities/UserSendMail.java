package com.example.demo.entities;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSendMail {
	private String firstName;
	private String lastName;
	private String emailAddress;
}