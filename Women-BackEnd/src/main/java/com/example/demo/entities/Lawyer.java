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
public class Lawyer {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer idLoyer;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTravail;
    
    private Boolean disponibilte;

    @OneToMany(mappedBy = "lawyer",cascade = CascadeType.ALL)
    private List<RendezVous> rendezVous;

    @ManyToOne
    private User userLawyer;

}
