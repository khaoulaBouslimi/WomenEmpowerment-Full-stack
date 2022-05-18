package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Publication;

public interface IPublicationService {
	
	public String AddPublication(int user_id,Publication pub) throws Exception;
	public List<Publication> RetrievePublication();
	public void UpdatePublicationById(Publication pub);
	public void DeletePublication(int id);
	public Publication GetPubById(int pubId);
	public void deletePubRedondant();
	public void DeletePostsWithoutInteraction();
	public List<Publication> AffichageDesSujetsAlaUne();
	Publication add(Publication publication);
		
	

}
