package com.example.demo.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.JobApplication;
import com.example.demo.repository.JobApplicationRepository;

@Service
public class JobApplicationServiceImp implements JobApplicationService {
	@Autowired
	JobApplicationRepository jobAppliRepo;
	
	//private JavaMailSender mailSender;

	// Save operation
	@Override
	public JobApplication addJobApplication(JobApplication jobAppli) {
		// TODO Auto-generated method stub
		jobAppliRepo.save(jobAppli);
		return jobAppli;
		
	}

	// Read operation
	@Override
	public List<JobApplication> fetchJobApplicationList() {
		// TODO Auto-generated method stub
		return (List<JobApplication>)
				jobAppliRepo.findAll();
	}

	// Update operation
	@Override
	public JobApplication updateJobApplication(JobApplication jobAppli, Long idApplication) {
		// TODO Auto-generated method stub
		
		JobApplication applicationDB = jobAppliRepo.findById(idApplication).get();
		
		if (Objects.nonNull(jobAppli.getName())
		            && !"".equalsIgnoreCase(jobAppli.getName())) {
			 applicationDB.setName(jobAppli.getName());
		        }
		 
//*********
		 if (Objects.nonNull(jobAppli.getAddress())
		            && !"".equalsIgnoreCase(jobAppli.getAddress())) {
			 applicationDB.setAddress(jobAppli.getAddress());
		        }
		 //*********
		 if (Objects.nonNull(jobAppli.getAge()))
		           // && !"".equalsIgnoreCase(jobAppli.getAge()))
				 {
			 applicationDB.setAge(jobAppli.getAge());
		        }
		 //*************
		 if (Objects.nonNull(jobAppli.getPostalCode()))
		           // && !"".equalsIgnoreCase(jobAppli.getPostalCode()))
				 {
			 applicationDB.setPostalCode(jobAppli.getPostalCode());
		        }
		 //*************
		 if (Objects.nonNull(jobAppli.getPhoneNumber()))
		         //   && !"".equalsIgnoreCase(jobAppli.getPhoneNumber()))
{
			 applicationDB.setPhoneNumber(	jobAppli.getPhoneNumber());
		        }
		 //***********
		 if (Objects.nonNull(jobAppli.getEmail())
		            && !"".equalsIgnoreCase(jobAppli.getEmail())) {
			 applicationDB.setEmail(jobAppli.getEmail());
		        }
		 //********
		 if (Objects.nonNull(jobAppli.getMsg())
		            && !"".equalsIgnoreCase(jobAppli.getMsg())) {
			 applicationDB.setMsg(jobAppli.getMsg());
		        }
		 //******
		 if (Objects.nonNull(jobAppli.getCv())
		            && !"".equalsIgnoreCase(jobAppli.getCv())) {
			 applicationDB.setCv(jobAppli.getCv());
		        }
		 
		 
		 
		return jobAppliRepo.save(applicationDB);
	}

	// Delete operation
	@Override
	public void deleteJobApplicationById(Long idApplication) {
		// TODO Auto-generated method stub
		jobAppliRepo.deleteById(idApplication);
	}

	//email
	/*public void sendEmail (String toEmail,String subject,String body){
	SimpleMailMessage message = new SimpleMailMessage();
	message.setFrom("maaloul.hazar4@gmail.com");
	message.setTo(toEmail);
	message.setText(body);
	message.setSubject(subject);
	
	mailSender.send(message);
	System.out.print("mail sent successfully....");
	
	}*/
	
	
	
}
