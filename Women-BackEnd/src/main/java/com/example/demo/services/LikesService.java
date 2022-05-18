package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.LikePosts;
import com.example.demo.entities.User;
import com.example.demo.repository.LikesRepository;
import com.example.demo.repository.PublicationRepository;
import com.example.demo.repository.UserRepository;

@Service
public class LikesService implements ILikeService {
	
	@Autowired
	LikesRepository like_rep;
	@Autowired
	PublicationRepository pub_rep;
	@Autowired
	UserRepository user_rep;
	
	
	@Override
	public void AddLike(LikePosts likes, int user_id, int pub_id) {
		// TODO Auto-generated method stub
		Iterable<User> user = user_rep.findAll();
		for (User user2 : user) {
		if (like_rep.FindUserByIdFromLikes(pub_id, user_id)==0) {
			
				if (user2.getId()== user_id) {
					pub_rep.findById(pub_id).map(p -> {
						  likes.setPub(p);
						  likes.setUser(user2);
						  likes.setLiked(true);
							
							return p;
					  });

				
				
			}
			
			like_rep.save(likes);
			
			
		}
		}
		
		
		
		/*Publication p1;
	  Iterable<User> user = user_rep.findAll();
	  for (User user2 : user) {
		  if (user2.getUser_id()== user_id) {
			  
			  if (like_rep.findAll().contains(likes)) {
				
			
			  if (user2.getLike()==null) {
				  
				  
				  pub_rep.findById(pub_id).map(p -> {
					  likes.setPub(p);
					  likes.setUser(user2);
					  likes.setLiked(true);
					  return p;
				  });
				  likes.setUser(user2);
				  
				like_rep.save(likes);
			}
			
		  }
		  }
		  else {
			likes.setLiked(false);
			
		}
		  
		
	}*/
	  
		
	}


	@Override
	public List<LikePosts> GetLikes() {
		// TODO Auto-generated method stub
		return like_rep.findAll();
	}


	@Override
	public void AddDislike(LikePosts likes, int user_id, int pub_id) {
		// TODO Auto-generated method stub
		Iterable<User> user = user_rep.findAll();
		for (User user2 : user) {
		if (like_rep.FindUserByIdFromDislikes(pub_id, user_id)==0) {
			
				if (user2.getId()== user_id) {
					pub_rep.findById(pub_id).map(p -> {
						  likes.setPub(p);
						  likes.setUser(user2);
						  likes.setLiked(false);
						  System.out.println("ok");
							
							return p;
					  });

				
				
			}
			
			like_rep.save(likes);
		}
		
		}
		
	}


	@Override
	public void Deletelike(int user_id, int pub_id) {
		// TODO Auto-generated method stub
		if (like_rep.FindUserByIdFromLikes(pub_id, user_id)==1){
			like_rep.DeleteLike(pub_id, user_id);}
		
	}


	@Override
	public void DeleteDislike(int user_id, int pub_id) {
		// TODO Auto-generated method stub
		if (like_rep.FindUserByIdFromDislikes(pub_id, user_id)==1){
			
			like_rep.DeleteDisLike(pub_id, user_id);
			
		}
		
	}
	
	
	

}
