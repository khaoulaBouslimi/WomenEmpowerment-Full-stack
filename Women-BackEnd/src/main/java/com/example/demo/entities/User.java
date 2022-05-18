package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Entity
@Data

public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@Size(max = 21)
	private String username;

	@NotBlank
	@Size(max = 51)
	@Email
	private String email;

	@NotBlank
	@Size(max = 110)
	private String password;

	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	private Date dob;
	private int age;
	private String adresse;
	private String phone;

	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Role> roles = new HashSet<>();











	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userRdv")
	private List<RendezVous> rdv = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userLawyer")
	private List<Lawyer> lawyers = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userDoctor")
	private List<Doctor> doctors = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userEvents")
	private List<Events> events = new ArrayList<>();


	// relation avec jobApplication
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<JobApplication> jobApplications;
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Complaints> complaints = new ArrayList<>();

	public User() {
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<TrainingSession> ts;
	
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	@JsonIgnore
	private List<LikeTs> likets;
	
	
	
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Publication> publication_id;
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Comments> comments;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<LikePosts > like_posts;
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<LikeComments> like_comments;
	
	
	

}
