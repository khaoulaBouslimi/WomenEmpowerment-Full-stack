package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.JobOffer;
import com.example.demo.repository.JobOfferRepository;
import com.example.demo.services.JobOfferService;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/joboffer")
public class JobOfferController {
	 @Autowired
	 JobOfferService jobOfferServ;
	 
	 //forpaging
	 JobOfferRepository jobOfferRepo;
	// Save operation
	    @PostMapping("/jobOffers")
	 
	    public JobOffer addJobOffer( @Valid @RequestBody JobOffer jobOffers)
	    {
	        return jobOfferServ.addJobOffer(jobOffers);
	    }
	    
	 // Read operation
	    @GetMapping("/jobOffers")
	    
	    public List<JobOffer> fetchJobOfferList()
	    {
	        return jobOfferServ.fetchJobOfferList();
	    }
	    

	 // Update operation
	    @PutMapping("/jobOffers/{idOffer}")
	 
	    public JobOffer updateJobOffer(@RequestBody JobOffer jobOffers, @PathVariable("idOffer") Long idOffer)
	    {
	        return jobOfferServ.updateJobOffer(
	        		jobOffers, idOffer);
	    }
	    
	 // Delete operation
	    @DeleteMapping("/jobOffers/{idOffer}")
	 
	    public String deleteJobOfferById(@PathVariable("idOffer")  Long idOffer)
	    {
	    	jobOfferServ.deleteJobOfferById(idOffer);
	        return "Deleted Successfully";
	    }
	    
	  
	    //filtrage de donnee 
	    @RequestMapping("/jobOffers/{sector}")
	    public List<JobOffer> getJobOfferBysector(@PathVariable String sector){
	    	return jobOfferServ.getJobOfferBysector(sector);
	    }
	    @RequestMapping("/jobOffers/experience/{experience}")
	    public List<JobOffer> getJobOfferByexperience(@PathVariable String experience){
	    	return jobOfferServ.getJobOfferByexperience(experience);
	    }
	    @RequestMapping("/jobOffers/location/{location}")
	    public List<JobOffer> getJobOfferBylocation(@PathVariable String location){
	    	return jobOfferServ.getJobOfferBylocation(location);
	    }
	    
	    
	    
	    //sort by and pagination
	    @GetMapping Page<JobOffer> getJobOffer(
	    		@RequestParam Optional<Integer>page,
	            @RequestParam Optional<String>sortBy)
	    {
	    	return jobOfferRepo.findAll(
	    			PageRequest.of(page.orElse(0), 5,Sort.Direction.ASC, sortBy.orElse("id"))
	    			);
	    }
	    
	    //pagination
	   // @RequestMapping(value = "/listPageable", method = RequestMethod.GET)
		//Page<JobOffer> JobOfferPageable(Pageable pageable) {
		//	return jobOfferRepo.findAll(pageable);

		//}
	  
}
