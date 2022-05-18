package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.JobOffer;

@Repository
public interface JobOfferRepository extends JpaRepository<JobOffer,Long> {

//filtrage de donnee
	public List<JobOffer> findBysector(String sector);
	public List<JobOffer> findByexperience(String experience);
	public List<JobOffer> findBylocation(String location);
	
	
	

	
	

}