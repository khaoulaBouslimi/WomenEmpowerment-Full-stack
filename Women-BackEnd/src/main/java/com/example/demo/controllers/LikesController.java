package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.LikePosts;
import com.example.demo.services.ILikeService;

@RestController
@RequestMapping("/api/likes")
@CrossOrigin("*")
public class LikesController {

	@Autowired
	ILikeService like_ser;

	@PostMapping("/Addlike/{user_id}/{pub_id}")
	public void Addlike(@PathVariable("user_id")int user_id,@PathVariable("pub_id")int pub_id,LikePosts like){

		like_ser.AddLike(like, user_id, pub_id);
		


	}
	@GetMapping("/GetLikes")
	public List<LikePosts> GetLikes(){
		return like_ser.GetLikes();
	}
	@PostMapping("/AddDislike/{user_id}/{pub_id}")
	public void AddDislike(@PathVariable("user_id")int user_id,@PathVariable("pub_id")int pub_id,LikePosts like){

		like_ser.AddDislike(like, user_id, pub_id);
		


	}
	@DeleteMapping("DelLike/{user_id}/{pub_id}")
	public void DeleteLike(@PathVariable("user_id")int user_id,@PathVariable("pub_id")int pub_id){
		like_ser.Deletelike(user_id, pub_id);
	}
	@DeleteMapping("DelDisLike/{user_id}/{pub_id}")
	public void DeleteDisLike(@PathVariable("user_id")int user_id,@PathVariable("pub_id")int pub_id){
		like_ser.DeleteDislike(user_id, pub_id);
	}

}
