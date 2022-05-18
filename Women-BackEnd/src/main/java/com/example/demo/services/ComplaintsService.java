package com.example.demo.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entities.Complaints;

public interface ComplaintsService {

	public Complaints addComplaints(Complaints complaints);

	public Complaints updateComplaints(Complaints complaints);

	public void deleteComplaints(Long id);
	
	public List<Complaints> getAll();

	public Complaints findById( Long id);

	public int NmbreComplaints();

	Complaints AddComplaints(Integer id, Complaints com);
	
	Complaints affecterUserAComplaints(Long idR,Integer id);
}
