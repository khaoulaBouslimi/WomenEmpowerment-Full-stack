package com.example.demo.services;

import com.example.demo.entities.LikeTs;

public interface ILikeTsService {

	
//	public List<LikePosts> GetLikes();
	public void AddDislikeToTrainingSession(LikeTs likes, int user_id,int idTs);
	public void Deletelike(int idUser,int idTs);
	public void DeleteDislike(int idUser,int idTs);
	
	public void AddLikesToTrainingSession(LikeTs likets,int idUser,int idTs);
	
}
