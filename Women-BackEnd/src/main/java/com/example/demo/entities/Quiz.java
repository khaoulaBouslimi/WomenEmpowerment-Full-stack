package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
public class Quiz implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idQuiz ;
	
	@OneToOne
	@JsonIgnore
	private User createdBy;
	
	@Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.")
	@NotNull(message = "Please provide a name")
	private String name;

	@Size(max = 500, message = "The description can't be longer than 500 characters.")
	@NotNull(message = "Please, provide a description")
	private String description;
	
	@Size(max = 500, message = "The description can't be longer than 500 characters.")
	@NotNull(message = "Please, provide the name of the trainer")
	private String trainerSname;

	private String duration ;

	private Boolean isPublished = false;
	
	@Size(max = 500, message = "The description can't be longer than 500 characters.")
	@NotNull(message = "Please, provide the location")
	private String location ;

	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Question> questions;


	

	
	

}
