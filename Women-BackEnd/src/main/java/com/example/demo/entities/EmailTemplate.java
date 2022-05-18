package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;

import lombok.Data;

@Entity
@Table( name = "EmailTemplate")
@Data
public class EmailTemplate {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idEmail")
	private Long idEmail; // Clé primaire
	
	
	@Email
	private String sendTo;
	@Max(value = 100)
	private String subject;
	@Max(value = 500)
	private String body;

	
}
