package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Complaints;
import com.example.demo.entities.User;
import com.example.demo.repository.ComplaintsRepository;
import com.example.demo.repository.UserRepository;


@Service
public class ComplaintsServiceImpl implements ComplaintsService{

	@Autowired
	private ComplaintsRepository complaintsRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	
	@Override
	public Complaints addComplaints(Complaints complaints) {
		
		return complaintsRepository.save(complaints);
	}

	@Override
	public Complaints updateComplaints(Complaints complaints) {
	
		return complaintsRepository.save(complaints);
	}

	@Override
	public void deleteComplaints(Long id) {
		complaintsRepository.deleteById(id);
		
	}

	@Override
	public List<Complaints> getAll() {
		return complaintsRepository.findAll();
	}

	@Override
	public Complaints findById(Long id) {
		return complaintsRepository.findById(id).orElse(null);
	}

	@Override
	public int NmbreComplaints() {
	
		return complaintsRepository.findAll().size();
		
	}
	
	@Override
	public Complaints AddComplaints(Integer id,Complaints com) {
		// TODO Auto-generated method stub

		return userRepository.findById(id).map(user -> {
			com.setUser(user);
			return complaintsRepository.save(com);
		}).get();
		
	}

	@Override
	public Complaints affecterUserAComplaints(Long idR, Integer idU) {
		  Complaints com=complaintsRepository.findById(idR).get();
	        User us=userRepository.findById(idU).get();
	        com.setUser(us);

	        return complaintsRepository.save(com);
	}

}
