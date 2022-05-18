package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.LikeTs;
import com.example.demo.entities.TrainingSession;

public interface ITrainingSessionService {

	
	public TrainingSession saveTS(TrainingSession ts);
	
	public void deleteTsById(Integer id);
	
	public List<TrainingSession> getAllTrainingSessions();
	
	public TrainingSession findTrainingSession(Integer id) ;
	
	public TrainingSession updateTrainingSession(TrainingSession newTrainingSession, Integer id);
	
	
	/**************************************Reaction*************************************************/
	
	
	public void AddLikesToTrainingSession(LikeTs likets,int idUser,int idTs);

}
