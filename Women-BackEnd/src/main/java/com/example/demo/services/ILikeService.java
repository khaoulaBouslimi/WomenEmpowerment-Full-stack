package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.LikePosts;

public interface ILikeService {
	
	public void AddLike(LikePosts likes, int user_id,int pub_id);
	public List<LikePosts> GetLikes();
	public void AddDislike(LikePosts likes, int user_id,int pub_id);
	public void Deletelike(int user_id,int pub_id);
	public void DeleteDislike(int user_id,int com_id);
	
	

}
