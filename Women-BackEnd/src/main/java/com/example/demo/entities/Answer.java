package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;




@Entity
@Data

public class Answer implements Serializable  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idanswer;

	private String answerorder;

	@Size(min = 1, max = 1500, message = "The answer should be less than 1500 characters")
	@NotBlank(message = "No answer text provided.")
	private String answertext;
	
	

	@ManyToOne
	@JsonIgnore
	private Question question;

	



}
