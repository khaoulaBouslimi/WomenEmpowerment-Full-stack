package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Complaints;
import com.example.demo.repository.ComplaintsRepository;
import com.example.demo.services.ComplaintsService;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api/complaints")
public class ComplaintsController {
	@Autowired
	private ComplaintsService complaintsService;
	@Autowired
	private ComplaintsRepository complaintsRepository;
	
	@PostMapping("/add")
	public Complaints addComplaints(@RequestBody Complaints complaints) {
		return complaintsService.addComplaints(complaints) ;
		
	} 
	@PutMapping("/update")
	public Complaints updateComplaints(@RequestBody Complaints complaints) {
		return complaintsService.updateComplaints(complaints);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteComplaints(@PathVariable Long id) {
		
		complaintsService.deleteComplaints(id);
		
	}
	@GetMapping("/all")
	public List<Complaints> getAll(){
		return complaintsService.getAll();
	}
	
	@GetMapping("/get/{id}")
	public Complaints findById(@PathVariable Long id) {
		return complaintsService.findById(id);
	}
	@GetMapping("/nbre")
	public int NmbreComplaints() {
		return complaintsService.NmbreComplaints()	;}
	
	@PostMapping("/add/{id}")
     public	String AddComplaints(@PathVariable Integer id, @RequestBody Complaints com){
		List<String> dic = complaintsRepository.Dictionnaire();
		for (int i = 1; i <= dic.size(); i++) {
			if (com.getTopic().contains(dic.get(i-1))) {
				break;
			}
			else{
				if (i == dic.size()) {
					complaintsService.AddComplaints(id, com);
					return "complaints added succesfully";
				}
			}
			
		}
		return "can not add complaints which contains a forbidden word";
		
	}
	@GetMapping("/affecter/{idR}/{idU}")
	public Complaints affecterUserAComplaints(@PathVariable Long idR,@PathVariable Integer idU) {
		return complaintsService.affecterUserAComplaints(idR, idU);
	}
	

}
