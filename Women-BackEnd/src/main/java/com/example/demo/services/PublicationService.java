package com.example.demo.services;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Publication;
import com.example.demo.repository.PublicationRepository;
import com.example.demo.repository.UserRepository;

@Service
public class PublicationService implements IPublicationService {

	@Autowired
	PublicationRepository publicationRep;

	@Autowired
	UserRepository userRep;

	
	@Override
	public Publication add(Publication publication) {
		return publicationRep.save(publication);
	}



	@Override
	public String AddPublication(int user_id,Publication pub) throws Exception {
		// TODO Auto-generated method stub
		/*List<String> title = publicationRep.findpubtitle();
		List<String> pub_txt = publicationRep.findpubtxt();

		int b=0,c=0;
		for (int i = 1; i <= title.size(); i++) {
			if (pub.getTitle().equalsIgnoreCase(title.get(i-1))) {

				for (int j = 1; j <= pub_txt.size(); j++) {
					if (pub.getPublication_txt().equalsIgnoreCase(pub_txt.get(j-1))) {

						break;

					}
					else {
						if (j == pub_txt.size()) {
							userRep.findById(user_id).map(user -> {



								pub.setUser(user);


								publicationRep.save(pub);
								return user;

							}).get();
							return "publication added succesfully";
						}
					}
				}
				break;
			}
			else{
				if (i == title.size()) {
					userRep.findById(user_id).map(user -> {



						pub.setUser(user);


						publicationRep.save(pub);
						return user;

					}).get();
					return "publication added succesfully";
				}
			}
			
		}*/
		userRep.findById(user_id).map(u ->{
			pub.setUser(u);
			publicationRep.save(pub);
			return u;
		});
		return "";


		




	}




	@Override
	public List<Publication> RetrievePublication() {
		// TODO Auto-generated method stub
		List<Publication> pub = (List<Publication>) publicationRep.findAll();
		return pub;
	}




	@Override
	public void UpdatePublicationById(Publication pub) {
		// TODO Auto-generated method stub

		this.publicationRep.save(pub);
	}




	@Override
	public void DeletePublication(int id) {
		// TODO Auto-generated method stub

		this.publicationRep.deleteById(id);

	}









	@Override
	public Publication GetPubById(int pubId) {
		// TODO Auto-generated method stub

		return publicationRep.findById(pubId).get();

	}
	public static int min(int... numbers) {
        return Arrays.stream(numbers)
          .min().orElse(Integer.MAX_VALUE);
    }
public static int max(int... numbers) {
        return Arrays.stream(numbers)
          .max().orElse(Integer.MAX_VALUE);
    }
    public static double levenshtein(String s0, String s1) {
	int len0 = s0.length()+1;
	int len1 = s1.length()+1;
    int m = max(len0, len1);
	// the array of distances
	int[] cost = new int[len0];
	int[] newcost = new int[len0];
 
	// initial cost of skipping prefix in String s0
	for(int i=0;i<len0;i++) cost[i]=i;
 
	// dynamicaly computing the array of distances
 
	// transformation cost for each letter in s1
	for(int j=1;j<len1;j++) {
 
		// initial cost of skipping prefix in String s1
		newcost[0]=j-1;
 
		// transformation cost for each letter in s0
		for(int i=1;i<len0;i++) {
 
			// matching current letters in both strings
			int match = (s0.charAt(i-1)==s1.charAt(j-1))?0:1;
 
			// computing cost for each transformation
			int cost_replace = cost[i-1]+match;
			int cost_insert  = cost[i]+1;
			int cost_delete  = newcost[i-1]+1;
 
			// keep minimum cost
			newcost[i] = min(cost_insert, cost_delete, cost_replace);
		}
 
		// swap cost/newcost arrays
		int[] swap=cost; cost=newcost; newcost=swap;
	}
 
	// the distance is the cost for transforming all letters in both strings
	return (cost[len0-1]*100)/m;
    }



    @Scheduled(fixedDelay= 1000*60)
	@Override
	public void deletePubRedondant() {
		// TODO Auto-generated method stub
		List<String> pub = publicationRep.findpubtxt();
		for (int i = 0; i < pub.size(); i++) {
			for (int j = i+1; j < pub.size(); j++) {
				if (levenshtein(pub.get(i), pub.get(j))<50.0) {
					publicationRep.deleteSujetRedondant(pub.get(j));	
				}
			}
			
		}
		
	}
    @Override
    public void DeletePostsWithoutInteraction(){
    	List<Publication> p = publicationRep.findAll();
    	for (int i = 0; i < p.size(); i++) {
			if (publicationRep.NbreCommentsBypub(p.get(i))<=2 && publicationRep.NbreInteractionBypub(p.get(i))<=2) {
				
				publicationRep.deleteById(p.get(i).getId());
				publicationRep.DeleteCommentsByPub(p.get(i));
				publicationRep.DeleteInteractionsByPub(p.get(i));
				publicationRep.DeleteInteractionsByCommentsByPuub(p.get(i));
			}
		}
    }
    
    public List<Publication> AffichageDesSujetsAlaUne(){
    	Comparator<Publication> comp = (x,y) -> y.getComments().size()-x.getComments().size();
    	return publicationRep.findAll().stream().sorted(comp).collect(Collectors.toList());
    }






}
