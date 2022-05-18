package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Comments;
import com.example.demo.entities.LikeComments;

public interface ICommentsService {
	
	public Comments AddComments(int user_id,Comments com,int pub_id);

	public void UpdateCommentsById(Comments com, int id);
	public void DeleteComments(int id);
	public void AddLikesComments(LikeComments like_com,int user_id,int com_id);
	public void AddloveComments(LikeComments like_com,int user_id,int com_id);
	public void AddHahaComments(LikeComments like_com,int user_id,int com_id);
	public void AddSadComments(LikeComments like_com,int user_id,int com_id);
	public void AddAngryComments(LikeComments like_com,int user_id,int com_id);

	List<Comments> getByPublId(Integer id);

	List<Comments> getByPubId(Integer id);

	


}
