package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Certificate {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCertificate;
	
	private String description;
	
	private Date duree ;
	
	private String Title;

}
