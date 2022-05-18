package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
public class LikeTs {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Like_id;
	

	private boolean isLiked;
	
	@Enumerated(EnumType.STRING)
	private InteractionTs interactionType;
	
	@ManyToOne
	@JoinColumn(name="id")
	@JsonIgnore
	private User user;
	
	
	
	
	@ManyToOne
	@JoinColumn(name="idTS")
	@JsonIgnore
	private TrainingSession ts ;
	
}
