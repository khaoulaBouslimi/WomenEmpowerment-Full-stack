package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Comments;
import com.example.demo.entities.LikeComments;
import com.example.demo.entities.Publication;
import com.example.demo.repository.CommentsRepository;
import com.example.demo.services.CommentsService;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins ="http://localhost:4100" , maxAge = 3600)
public class CommentsController  {

//	@Autowired
//	ICommentsController commentInterf;
	@Autowired
	CommentsService comService;
	@Autowired
	CommentsRepository com_rep;

	@PostMapping("/AddComments/{userId}/{pubId}")
	public String AddComment(@RequestBody Comments com,@PathVariable(value = "userId") int userId,@PathVariable(value = "pubId") int pubId){
		List<String> dic = com_rep.Dictionnaire();
		for (int i = 1; i <= dic.size(); i++) {
			if (com.getComment_field().contains(dic.get(i-1))) {
				break;
			}
			else{
				if (i == dic.size()) {
					comService.AddComments(userId, com, pubId);
					return "comments added succesfully";
				}
			}
			
		}
		return "can not add comment which contains a forbidden word";



	}
	
	@GetMapping("/get-comment/{pubId}")
	public List<Comments> getByPublId(@PathVariable Integer pubId){
		return comService.getByPubId(pubId);
	}
	@PostMapping("AddLikesComments/{userId}/{comId}")
	public void AddLikeCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeComments like){
		comService.AddLikesComments(like, user_id, comId);
	}
	@PostMapping("AddloveComments/{userId}/{comId}")
	public void AddloveCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeComments like){
		comService.AddloveComments(like, user_id, comId);
	}
	@PostMapping("AddhahaComments/{userId}/{comId}")
	public void AddHahaCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeComments like){
		comService.AddHahaComments(like, user_id, comId);
	}
	@PostMapping("AddsadComments/{userId}/{comId}")
	public void AddsadCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeComments like){
		comService.AddSadComments(like, user_id, comId);
	}
	@PostMapping("AddangryComments/{userId}/{comId}")
	public void AddangryCom(@PathVariable("userId")int user_id,@PathVariable("comId")int comId,LikeComments like){
		comService.AddAngryComments(like, user_id, comId);
	}
	

}
