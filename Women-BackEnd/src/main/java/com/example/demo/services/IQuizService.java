package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entities.Question;
import com.example.demo.entities.Quiz;
import com.example.demo.entities.TrainingSession;
import com.example.demo.entities.User;

public interface IQuizService {

	public Quiz addQuiz(Quiz quiz);
	
	public Quiz save(Quiz quiz, User user);

	Page<Quiz> findAll(Pageable pageable);

	Page<Quiz> findAllPublished(Pageable pageable);

//	Page<Quiz> findQuizzesByUser(User user, Pageable pageable);
//
	public Quiz find(Integer id) ;

	Quiz update(Quiz currentquiz,  Integer idQuiz) ;

	void deleteById(Integer id) ;

	Page<Quiz> search(String query, Pageable pageable);

	Result checkAnswers(Quiz quiz, List<Response> answersBundle);

	void publishQuiz(Quiz quiz);
	
	Question addQuestionToQuiz(Question q , Integer idQuiz);
	
	public List<Quiz> GetAllquiz();

	
}
