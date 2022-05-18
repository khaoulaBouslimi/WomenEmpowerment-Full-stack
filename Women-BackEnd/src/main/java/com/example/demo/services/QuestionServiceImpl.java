package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Answer;
import com.example.demo.entities.Question;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements IQuestionSerivce {

	@Autowired
	QuestionRepository questionRespository;
	
	@Autowired
	AnswerRepository answerepo ;
	
	@Autowired
	IAnswerService ianswerService ;
	

	
	
	
	@Override
	public Question saveQuestion(Question question) {
		questionRespository.save(question);
		return question;
	}

	@Override
	public Question addQuestion(Question question, int id) {
		Answer a = answerepo.findById(id).orElse(null);
		question.setCorrectAnswer(a);
		questionRespository.save(question);
		return question;
	}

	@Override
	public void deleteQuestionById(Integer id) {
		questionRespository.deleteById(id);
		
	}

	@Override
	public void deleteQuestion(Question question) {
		questionRespository.delete(question);
	}

	@Override
	public List<Question> getAllQuestions() {
		return questionRespository.findAll();
	}

	@Override
	public Question find(Integer id) {
		Question question = questionRespository.findById(id).orElse(null);
		return question;
	}

	
	/************************************** update Question *******************************************/
	
	private void permutQuestions(Question currentQuestion, Question newQuestion) {
		currentQuestion.setQuestiontext(newQuestion.getQuestiontext());

		if (newQuestion.getQuestionorder() != null)
			currentQuestion.setQuestionorder(newQuestion.getQuestionorder());
		if (newQuestion.getIsvalid() != null  )
			currentQuestion.setIsvalid(newQuestion.getIsvalid());
		if (newQuestion.getQuestionorder() != null)
			currentQuestion.setQuestionorder(newQuestion.getQuestionorder());	
	}
	
	@Override
	public Question updateQuestion(Question newQuestion, Integer id) {
		Question currentQuestion = find(newQuestion.getIdQuestion());
		permutQuestions(currentQuestion, newQuestion);
		
		return questionRespository.save(currentQuestion);
	}
	
	
   /*********************************************** getCorrectAnswer *********************************************************/
	
	@Override
	public Answer getCorrectAnswer(Question question) {	
		return question.getCorrectAnswer();
	}

	/***************************************** checkIsCorrectAnswerById *****************************************************/
	
	@Override
	public Boolean checkIsCorrectAnswerById( int idQuestion, String answerorder) {
		Question question = find(idQuestion);
		
		return question.getCorrectAnswer().getAnswerorder().equals(answerorder) ;
	}
	
	

	/***************************************************************************************************************/


	@Override
	public void setCorrectAnswer(Question question, Answer answer) {
			question.setCorrectAnswer(answer);
			saveQuestion(question);
		
		
	}


	/******************************************** countValidQuestionsInQuiz *******************************************************************/

	@Override
	public int countValidQuestionsInQuiz(Integer idquiz) {
		return questionRespository.countValidQuestionsByQuizAndIsValidTrue(idquiz);
	}

	@Override
	public int countQuestionsInQuiz(Integer idquiz) {
		
		return questionRespository.countQuestionsInTheQuiz( idquiz);
	}
	
	/***************************************************************************************************************/
	
	

	@Override
	public List<Question> findQuestionsByQuiz(Integer idQuiz) {
		return questionRespository.findQuestionsByQuizOrderByAsc(idQuiz);
	}

	@Override
	public List<Question> findValidQuestionsByQuiz(Integer idQuiz) {
		
		return questionRespository.findValidQuestionsByQuizOrderByOrderAsc(idQuiz);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/***************************************************************************************************************/
	
	
	private void checkAndUpdateQuestionValidity2(Integer idQuestion, boolean newState) {
		Question question = find(idQuestion);
		if (!question.getIsvalid()) {
			question.setIsvalid(newState);
			saveQuestion(question);
		}
	}
	
	

	private void setCorrectAnswerIfFirst2(Integer idQuestion, int count, Answer newAnswer) {
		Question question = find(idQuestion);
		if (count == 0) {
			question.setCorrectAnswer(newAnswer);
			questionRespository.save(question);
		}
	}

	private void checkQuestionInitialization2(Integer idQuestion, int count, Answer newAnswer) {
		
		checkAndUpdateQuestionValidity2(idQuestion, true);
		setCorrectAnswerIfFirst2(idQuestion, count, newAnswer);
	}
	
	private Answer updateAndSaveAnswer2(Answer answer, Integer idQuestion, int count) {
		
		Question question = find(idQuestion);
		String s=Integer.toString(count + 1);
		answer.setAnswerorder(s);
		answer.setQuestion(question);
		return ianswerService.saveAnwser(answer);
	}
	
	@Override
	public Answer addAnswerToQuestion(Answer answer, Integer idQuestion) {
		int count = ianswerService.countAnswersInQuestion(idQuestion);
		Answer newAnswer = updateAndSaveAnswer2(answer, idQuestion, count);

		checkQuestionInitialization2(idQuestion, count, newAnswer);

		return newAnswer;
	}
	
	/***************************************************************************************************************/

	

	

	
	
	

	

	
	

	

	

	
	
	
}
