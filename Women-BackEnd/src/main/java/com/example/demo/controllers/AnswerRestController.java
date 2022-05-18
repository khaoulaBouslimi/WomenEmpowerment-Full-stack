package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Answer;
import com.example.demo.services.IAnswerService;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class AnswerRestController {

	@Autowired
	
	IAnswerService ianswerService;
	
	@PostMapping("/AjouterUneReponseAuneQuestion/{idQuestion}")
	@ResponseBody
	public Answer addAnswer(@RequestBody Answer answer , @PathVariable int idQuestion) {
		
		return ianswerService.addAnswer(answer, idQuestion) ;
		
	}
	
	
	
	@DeleteMapping("/SupprimerUneReponse/{id}")
	@ResponseBody
	public void deleteAnswerById(@PathVariable("id") Integer idanswer) {
		ianswerService.deleteAnswerById(idanswer);
	}
	
	
	@GetMapping("/RechercherLaReponseAvec/{id}")
	@ResponseBody
	public Answer find(@PathVariable("id") Integer idanswer) {		
		return ianswerService.find(idanswer);
	}
	
	
	
	@PutMapping("/updateUneReponse/{id}")
	@ResponseBody
	public Answer update(@RequestBody Answer newAnswer,  @PathVariable("id") Integer idanswer) {
		newAnswer.setIdanswer(idanswer);
		return ianswerService.update(newAnswer, idanswer);
		
	}
	
	@GetMapping("/findAnswersByQuestionOrderByOrderAsc/{idQuestion}")
	@ResponseBody
	public List<Answer> findAnswersByQuestionOrderByOrderAsc(@PathVariable("idQuestion") int idQuestion){
		return ianswerService.findAnswersByQuestion(idQuestion);
	}
	
	@GetMapping("/countAnswersInQuestion/{idQuestion}")
	@ResponseBody
	public int countAnswersInQuestion(@PathVariable("idQuestion")  int idQuestion) {
		return ianswerService.countAnswersInQuestion(idQuestion);
	}
	
	@GetMapping("/AfficherToutesLesReponses")
	@ResponseBody
	public List<Answer> getAllanswers(){
		List<Answer> liste = ianswerService.getAllanswers();
		return liste ;
	}
	
	
	
}
