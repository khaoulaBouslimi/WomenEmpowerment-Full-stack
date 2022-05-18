package com.example.demo.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.JobOffer;
import com.example.demo.repository.JobOfferRepository;

@Service
public class JobOfferServiceImp implements JobOfferService {
	@Autowired
	JobOfferRepository jobOfferRepo;
	
	
	
	// Save operation
	@Override
	public JobOffer addJobOffer(JobOffer jobOffers) {
		// TODO Auto-generated method stub
		jobOfferRepo.save(jobOffers);
		return jobOffers;
	}

	// Read operation
	@Override
	public List<JobOffer> fetchJobOfferList() {
		// TODO Auto-generated method stub
		
		return (List<JobOffer>)
				jobOfferRepo.findAll();
	}
	
	// Update operation
	@Override
	public JobOffer updateJobOffer(JobOffer jobOffers, Long idOffer) {
		// TODO Auto-generated method stub
		JobOffer offerDB = jobOfferRepo.findById(idOffer).get();
		 if (Objects.nonNull(jobOffers.getDescription())
		            && !"".equalsIgnoreCase(
		            		jobOffers.getDescription())) {
		            offerDB.setDescription(
		            		jobOffers.getDescription());
		        }
		 //***
		 if (Objects.nonNull(jobOffers.getSector())
		            && !"".equalsIgnoreCase(
		            		jobOffers.getSector())) {
		            offerDB.setSector(
		            		jobOffers.getSector());
		        }
		 //*********
		 if (Objects.nonNull(jobOffers.getExperience())
		            && !"".equalsIgnoreCase(
		            		jobOffers.getExperience())) {
		            offerDB.setExperience(
		            		jobOffers.getExperience());
		        }
		 //***********
		 if (Objects.nonNull(jobOffers.getLocation())
		            && !"".equalsIgnoreCase(
		            		jobOffers.getLocation())) {
		            offerDB.setLocation(
		            		jobOffers.getLocation());
		        }
		return jobOfferRepo.save(offerDB);
	}
	
	// Delete operation
	@Override
	public void deleteJobOfferById(Long idOffer) {
		// TODO Auto-generated method stub
		jobOfferRepo.deleteById(idOffer);
	}
//**********************************
	//filtrage de donnee 
	@Override
	public List<JobOffer> getJobOfferBysector(String sector) {
		// TODO Auto-generated method stub
		return jobOfferRepo.findBysector(sector);
	}

	@Override
	public List<JobOffer> getJobOfferByexperience(String experience) {
		// TODO Auto-generated method stub
		return jobOfferRepo.findByexperience(experience);
	}

	@Override
	public List<JobOffer> getJobOfferBylocation(String location) {
		// TODO Auto-generated method stub
		return jobOfferRepo.findBylocation(location);
	}
	
//**************************
	
	
	
	
	
}

