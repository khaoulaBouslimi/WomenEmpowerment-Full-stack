package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Question;
import com.example.demo.entities.Quiz;
import com.example.demo.entities.TrainingSession;
import com.example.demo.entities.User;
import com.example.demo.services.IQuizService;
import com.example.demo.services.Response;
import com.example.demo.services.Result;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class QuizRestController {

	@Autowired
	IQuizService iQuizService;
	
	
	@PostMapping("/findAllTheQuizZz")
	@ResponseBody
	public Quiz save(@RequestBody Quiz quiz, @RequestBody  User user) {
		return iQuizService.save(quiz, user);
	}
	
	
	
	@GetMapping("/findAllTheQuizZz")
	@ResponseBody
	public Page<Quiz> findAll(Pageable pageable,
			@RequestParam(required = false, defaultValue = "false") Boolean published) {
		
		if (published) {
			return iQuizService.findAllPublished(pageable);
		} else {
			return iQuizService.findAll(pageable);
		}
	}
	
	
	@PostMapping("/AjouterUnQuizZz")
	@ResponseBody
	public Quiz addQuiz(@RequestBody Quiz quiz){
		return iQuizService.addQuiz(quiz);
	}
	
	
	@GetMapping("/finQuizById/{idQuiz}")
	@ResponseBody
	public Quiz find(@PathVariable("idQuiz") Integer idQuiz) {
		return iQuizService.find(idQuiz);
	}
	
	
	@PutMapping("/updateQuiz/{idQuiz}")
	@ResponseBody
	public Quiz update(@RequestBody Quiz newquiz, @PathVariable("idQuiz") Integer idQuiz) {
		newquiz.setIdQuiz(idQuiz);
		return iQuizService.update(newquiz, idQuiz);
	}
	
	
	@DeleteMapping("/deleteQuizById/{idQuiz}")
	@ResponseBody
	void deleteById(@PathVariable("idQuiz") Integer id){
		iQuizService.deleteById(id);
	}
	
	
	@GetMapping("/Search")
	@ResponseBody
	public Page<Quiz> search(@RequestBody String query, Pageable pageable) {
		return iQuizService.search(query, pageable);
	}
	
	
	
	@RequestMapping(value = "/submitAnswers/{quiz_id}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public Result playQuiz(@PathVariable("quiz_id") Integer quiz_id, @RequestBody List<Response> answersBundle) {
		Quiz quiz = iQuizService.find(quiz_id);
		return iQuizService.checkAnswers(quiz, answersBundle);
	}

	
	
	
	
	
	
	@PostMapping("/addQuestionToQuiz/{idQuiz}")
	@ResponseBody
	public Question addQuestionToQuiz(@RequestBody Question question,@PathVariable("idQuiz") Integer idQuiz){
		return iQuizService.addQuestionToQuiz(question, idQuiz);
	}
	
	
	
	@GetMapping("/GetAllquiz")
	@ResponseBody
	public List<Quiz> GetAllquiz() {
		List<Quiz> liste = iQuizService.GetAllquiz();
		return liste ;
	}
	
	
	
	
	
	
	
	
	
	
	
}
