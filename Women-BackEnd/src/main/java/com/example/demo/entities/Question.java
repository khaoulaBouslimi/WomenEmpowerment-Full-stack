package com.example.demo.entities;



import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;




@Entity
@Data
public class Question implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idQuestion;

	private Integer questionorder;
	
	@Size(min = 2, max = 1500, message = "The question should be between 2 and 1500 characters")
	@NotBlank(message = "Question text not provided")
	private String questiontext;

	private Boolean isvalid = false;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Answer> answers;

	
	@OneToOne
	@JsonIgnore
	private Answer correctAnswer;

	@ManyToOne
	@JoinColumn(name="idquiz")
	@JsonIgnore
	private Quiz quiz;
	



//	@ManyToOne
//	private TrainingSession trainingSession;

	
	

}
