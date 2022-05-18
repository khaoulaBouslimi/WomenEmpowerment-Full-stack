package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.JobOffer;

public interface JobOfferService {
    // Save operation
	public JobOffer addJobOffer (JobOffer jobOffers); 
	// Read operation
	List<JobOffer> fetchJobOfferList();
	// Update operation
    JobOffer updateJobOffer(JobOffer jobOffers, Long idOffer);
    // Delete operation
    void deleteJobOfferById(Long idOffer);
    
  //filtrage de donnee 
	public List<JobOffer> getJobOfferBysector(String sector);
	public List<JobOffer> getJobOfferByexperience(String experience);
	public List<JobOffer> getJobOfferBylocation(String location);
    
    

}