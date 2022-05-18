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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Answer;
import com.example.demo.entities.Question;
import com.example.demo.services.IAnswerService;
import com.example.demo.services.IQuestionSerivce;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class QuestionRestController {

	@Autowired
	IQuestionSerivce iQuestionService;
	
	@Autowired
	IAnswerService iAnswerService;
	
	
	@PostMapping("/AjouterUneQuestion")
	@ResponseBody
	public Question saveQuestion(@RequestBody Question question) {
		return iQuestionService.saveQuestion(question);
	}
	
	@PostMapping("/AjouterUneQuestion/{idanswer}")
	@ResponseBody
	public Question addQuestion(@RequestBody Question question, @PathVariable int idanswer) {
		return iQuestionService.addQuestion(question, idanswer);
		
	}
	
	
	@DeleteMapping("/SupprimerUneQuestion/{id}")
	@ResponseBody
	public void deleteQuestionById(@PathVariable("id") Integer idQuestion) {
		iQuestionService.deleteQuestionById(idQuestion);
	}
	
	
	@GetMapping("/AfficherTousLesQuestions")
	@ResponseBody
	public List<Question> getAllQuestions() {
		List<Question> liste = iQuestionService.getAllQuestions();
		return liste ;
	}
	
	
	@GetMapping("/RechercherLaQuestionAvec/{id}")
	@ResponseBody
	public Question find(@PathVariable("id") Integer idQuestion) {
		return iQuestionService.find(idQuestion) ;
		
	}
	
	@PutMapping("/MisAJoursQuestion/{id}")
	@ResponseBody
	public Question updateQuestion(@PathVariable("id") int idQuestion,@RequestBody Question question) {
		question.setIdQuestion(idQuestion);
		return iQuestionService.updateQuestion(question, idQuestion);
	}
	
	
	@GetMapping("/{idQuestion}/correctAnswer")
	@ResponseBody
	public Answer getCorrectAnswer(@PathVariable Integer idQuestion) {	
		Question question = iQuestionService.find(idQuestion);
		return iQuestionService.getCorrectAnswer(question);
	}
	
	@GetMapping("/checkIsCorrectAnswerById/{idQuestion}/{answerorder}")
	@ResponseBody
	public Boolean checkIsCorrectAnswer(@PathVariable("idQuestion") int idQuestion,@PathVariable String answerorder) {
		return iQuestionService.checkIsCorrectAnswerById(idQuestion, answerorder);
	}
	  
	
	@PostMapping("/correctAnswer/{idQuestion}")
	@ResponseBody
	public void setCorrectAnswer(@PathVariable int idQuestion, @RequestParam Integer idanswer) {

		Question question = iQuestionService.find(idQuestion);
		Answer answer = iAnswerService.find(idanswer);
		iQuestionService.setCorrectAnswer(question, answer);
		
	}
	

	@GetMapping("/countValidQuestionsInQuiz/{idQuiz}")
	@ResponseBody
	public int countValidQuestionsInQuiz(@PathVariable("idQuiz") Integer idQuiz) {
		return iQuestionService.countValidQuestionsInQuiz(idQuiz);
	}
	
	@GetMapping("/countQuestionsInQuiz/{idQuiz}")
	@ResponseBody
	int countQuestionsInQuiz(@PathVariable("idQuiz") Integer idquiz){
		return iQuestionService.countQuestionsInQuiz(idquiz);
	}
	
	
	
	@PostMapping("/addAnswersToTheQuestion/{idQuiz}")
	@ResponseBody
	public Answer addAnswerToQuestion(@RequestBody Answer answer,@PathVariable("idQuiz") Integer idQuestion) {
		return iQuestionService.addAnswerToQuestion(answer, idQuestion);
	}
	
	@GetMapping("/findQuestionsInQuiz/{idQuiz}")
	@ResponseBody
	public List<Question> findQuestionsByQuiz(@PathVariable("idQuiz") Integer idQuiz) {
		return iQuestionService.findQuestionsByQuiz(idQuiz);
	}
	
	
	@GetMapping("/findValidQuestionsInQuiz/{idQuiz}")
	@ResponseBody
	public List<Question> findValidQuestionsByQuiz(@PathVariable("idQuiz") Integer idQuiz) {
		return iQuestionService.findQuestionsByQuiz(idQuiz);
	}
	
}
