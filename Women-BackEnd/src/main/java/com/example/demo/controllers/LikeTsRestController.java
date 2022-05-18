package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.LikeTs;
import com.example.demo.services.ILikeTsService;
import com.example.demo.services.LikeTsService;

@RestController
public class LikeTsRestController {
	
	@Autowired
	LikeTsService likeTsService ;
	@Autowired
	ILikeTsService iLikeTsService ;
	

	
	@PostMapping("/AddLikesToMyTs/{idUser}/{idTs}")
	@ResponseBody
	public void AddLikesToTrainingSession(@RequestBody LikeTs likets,@PathVariable("idUser") int idUser, @PathVariable("idTs") int idTs){
		iLikeTsService.AddLikesToTrainingSession(likets, idUser, idTs);
	}

	@PostMapping("/AddDislikeToTrainingSession/{idUser}/{idTs}")
	@ResponseBody
	public void AddDislikeToTrainingSession(@RequestBody LikeTs likes, @PathVariable("idUser") int user_id, @PathVariable("idTs") int idTs) {
		iLikeTsService.AddDislikeToTrainingSession(likes, user_id, idTs);
	}
	
	@DeleteMapping("/Deletelike/{idUser}/{idTs}")
	public void Deletelike(@PathVariable("idUser") int idUser, @PathVariable("idTs") int idTs){
		iLikeTsService.Deletelike(idUser, idTs);
	}
	
	
	@DeleteMapping("/DeleteDislike/{idUser}/{idTs}")
	public void DeleteDislike(@PathVariable("idUser") int idUser, @PathVariable("idTs") int idTs){
		iLikeTsService.DeleteDislike(idUser, idTs);
	}

}
