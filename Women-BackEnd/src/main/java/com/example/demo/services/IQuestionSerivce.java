package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Answer;
import com.example.demo.entities.Question;

public interface IQuestionSerivce {

	
	public Question saveQuestion(Question question) ;
	
	public Question find(Integer id);
	
	public Question updateQuestion(Question question, Integer id) ;
	
	List<Question> findQuestionsByQuiz(Integer idQuiz);

	List<Question> findValidQuestionsByQuiz(Integer idQuiz);
	
	public void deleteQuestion(Question question);
	
	public Boolean checkIsCorrectAnswerById(int idQuestion , String answerorder);
	
	public void setCorrectAnswer(Question question, Answer answer);
	
	public Answer getCorrectAnswer(Question question);
	
	Answer addAnswerToQuestion(Answer answer, Integer id);
	
	int countQuestionsInQuiz(Integer idquiz);

	int countValidQuestionsInQuiz(Integer idquiz);	

	public Question addQuestion(Question question, int id) ;

	public void deleteQuestionById(Integer id);

	public List<Question> getAllQuestions();
	


	


	
	
}
