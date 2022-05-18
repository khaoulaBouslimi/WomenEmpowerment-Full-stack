package com.example.demo.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table( name = "JobOffer")
public class JobOffer implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idOffer")
	private Long idOffer; // Clé primaire
	private String sector;
	private String experience;
	private String location;
	private String description;
	

	
	
	
	@OneToMany(mappedBy="jobOffers")
	private Set<JobApplication> jobApplications;
	
	

	
	
	
	
	
}
