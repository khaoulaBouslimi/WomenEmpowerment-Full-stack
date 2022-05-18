package com.example.demo.controllers;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Comments;
import com.example.demo.entities.Publication;
import com.example.demo.repository.CommentsRepository;
import com.example.demo.repository.PublicationRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.IPublicationService;

@RestController
@RequestMapping("/api/publication")
@CrossOrigin(origins ="http://localhost:4200" , maxAge = 3600)
public class PublicationControllerImp  {
	
	@Autowired
	IPublicationService pub_service;
	@Autowired
	UserRepository user_rep;
	@Autowired
	PublicationRepository pub_rep;
	@Autowired
	CommentsRepository com_rep;
	private byte[] bytes;
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}
	
	@GetMapping("/RetrievePublication")
	public List<Publication> retrieveAllPublications(){
		List<Publication> pub = pub_service.RetrievePublication();
		return pub;
	}
	
	@PostMapping("add")
	public Publication createPost(@RequestBody Publication publication) {
		return pub_service.add(publication) ;
	}
	
	@PostMapping("/AddPublication/{id}")
	public String AddPub( @RequestBody Publication pub,@PathVariable("id") int id) throws Exception{
		pub.setPic(this.bytes);
		
		this.bytes = null;
		
		return pub_service.AddPublication(id, pub);
		
		
		
	}
	
	@PutMapping("/UpdatePublication")
	public void UpdatePub(@RequestBody Publication pub){
		
		this.pub_service.UpdatePublicationById(pub);
		
	}
	
	@DeleteMapping("remove-publication/{id}")
	public void DeletePub(@PathVariable("id") int id){
		this.pub_service.DeletePublication(id);
	}
	
	@GetMapping("RetrievePublication/{id}")
	public Publication getPubByID(@PathVariable(value = "id")int id){
		
		
		return pub_service.GetPubById(id);
		
	}
	
	@GetMapping("RetrieveComments/{id}")
	public List<Comments> retrieveCOmmentsById(@PathVariable(value = "id")int id){
		
		return com_rep.RelevantComments(id);
	}
	
	@DeleteMapping("/deleteSujetRedondant")
	public void SuppressionDesSujetsRedondant(){
		pub_service.deletePubRedondant();
	} 
	@DeleteMapping("DeletePubWithoutInteraction")
	public void DeletePubWithoutInteraction(){
		pub_service.DeletePostsWithoutInteraction();
	}
	@GetMapping("GetPubAlaune")
	public List<Publication> getPubAlaUne(){
		return pub_service.AffichageDesSujetsAlaUne();
	}
	
	
	
	

}
