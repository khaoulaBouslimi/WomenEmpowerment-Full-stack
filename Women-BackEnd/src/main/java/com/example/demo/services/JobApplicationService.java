package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.JobApplication;

public interface JobApplicationService {
	// Save operation
		public JobApplication addJobApplication (JobApplication jobAppli); 
		// Read operation
		List<JobApplication> fetchJobApplicationList();
		// Update operation
		JobApplication updateJobApplication(JobApplication jobAppli, Long idApplication);
	    // Delete operation
	    void deleteJobApplicationById(Long idApplication);
	   
}
