package com.example.demo.entities;



	import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
	@Entity

	@Table( name = "JobApplication")
	public class JobApplication implements Serializable{
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name="idApplication")
		private Long idApplication; // Clé primaire
		private String name;
		private String address;
		private int age;
		private int postalCode;
		private int phoneNumber;
		private String email;
		private String msg;
		private String cv;
		
		//relation avec joboffers
		@ManyToOne
		JobOffer jobOffers;
		
		//relation avec user
		@ManyToOne
		User user;

		
		//getters setters
		public Long getIdApplication() {
			return idApplication;
		}

		public void setIdApplication(Long idApplication) {
			this.idApplication = idApplication;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(int postalCode) {
			this.postalCode = postalCode;
		}

		public int getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(int phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getCv() {
			return cv;
		}

		public void setCv(String cv) {
			this.cv = cv;
		}

		public JobOffer getJobOffers() {
			return jobOffers;
		}

		public void setJobOffers(JobOffer jobOffers) {
			this.jobOffers = jobOffers;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
//**********
		
	
		
}
