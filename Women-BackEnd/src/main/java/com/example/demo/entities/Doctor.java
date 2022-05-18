package com.example.demo.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity

	public class Doctor {
		 	@Id
		    @GeneratedValue(strategy = GenerationType.AUTO)
		    @Column(name = "id", nullable = false)
		    private Integer idDoc;

		    @Temporal(TemporalType.TIMESTAMP)
		    private Date DateTravail;
		    
		    private Boolean disponibilte;

		    @ManyToOne
		    private User userDoctor;

		   @OneToMany(cascade = CascadeType.ALL,mappedBy = "doctor")
			private List<RendezVous> rendezVous;

	}


