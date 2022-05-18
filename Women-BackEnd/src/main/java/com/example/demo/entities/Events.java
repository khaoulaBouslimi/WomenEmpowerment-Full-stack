package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Events {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String eventTopic;
    private String Description;
    @Temporal(TemporalType.DATE)
    private Date date;

    private String fileName;
    private String fileType;

    @Lob
    private byte[] data;


    @ManyToOne
    @JsonIgnore
    private User userEvents;
    @ManyToMany
    private List<Sponsor> sponsors = new ArrayList<>();

}
