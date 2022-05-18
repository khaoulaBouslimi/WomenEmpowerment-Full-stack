package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Question;
import com.example.demo.entities.Quiz;
import com.example.demo.entities.TrainingSession;
import com.example.demo.entities.User;
import com.example.demo.repository.QuizRepository;

@Service
public class QuizServiceImpl implements IQuizService {

	@Autowired
	QuizRepository quizRepository;
	
	@Autowired
	IQuestionSerivce iQuestionSerivce;
	
	
	
	@Override
	public Quiz save(Quiz quiz, User user) {
		quiz.setCreatedBy(user);
		return quizRepository.save(quiz);
	}

	@Override
	public Page<Quiz> findAll(Pageable pageable) {
		return quizRepository.findAll(pageable);
	}

	@Override
	public Page<Quiz> findAllPublished(Pageable pageable) {
		
		return quizRepository.findByIsPublishedTrue(pageable) ;
	}

	@Override
	public Quiz addQuiz(Quiz quiz) {
		quizRepository.save(quiz);
		return quiz;
	}
	
	@Override
	public Quiz find(Integer idQuiz) {
		Quiz q = quizRepository.findById(idQuiz).orElse(null);
		return q ;
		
	}
	
	/***************************************************** Update **********************************************************/
	
	private void mergeQuiz(Quiz currentQuiz, Quiz newQuiz) {
		currentQuiz.setDescription(newQuiz.getDescription());

		if(newQuiz.getIsPublished() != null)
			currentQuiz.setIsPublished(newQuiz.getIsPublished());
		
		if(newQuiz.getName() != null)
			currentQuiz.setName(newQuiz.getName());
		
		if(newQuiz.getTrainerSname() != null)
			currentQuiz.setTrainerSname(newQuiz.getTrainerSname());
		if(newQuiz.getDuration() != null)
			currentQuiz.setDuration(newQuiz.getDuration());
		if(newQuiz.getLocation() != null)
			currentQuiz.setLocation(newQuiz.getLocation());
		
	}

	@Override
	public Quiz update(Quiz newquiz, Integer idQuiz) {
		Quiz currentquiz = find(newquiz.getIdQuiz());
		
		mergeQuiz(currentquiz, newquiz);
		return quizRepository.save(currentquiz);
	}
	

	/***************************************************************************************************************************/

	@Override
	public void deleteById(Integer id) {
		quizRepository.deleteById(id);
		
	}

	@Override
	public Page<Quiz> search(String query, Pageable pageable) {
		return quizRepository.searchByName(query, pageable);
	}

//	@Override
//	public tn.esprit.Service.Result checkAnswers(Quiz quiz, List<Response> answersBundle) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	@Override
	public Result checkAnswers(Quiz quiz, List<Response> answersBundle) {
		Result results = new Result();

		for (Question question : quiz.getQuestions()) {
			boolean isFound = false;

			if (!question.getIsvalid()) {
				continue;
			}

			for (Response bundle : answersBundle) {
				if (bundle.getQuestion().equals(question.getIdQuestion())) {
					isFound = true;
					//results.addAnswer(questionService.checkIsCorrectAnswer(question, bundle.getSelectedAnswer()));
					//results.addAnswer(iQuestionSerivce.checkIsCorrectAnswerById(idQuestion, answerorder)
					results.addAnswer(iQuestionSerivce.checkIsCorrectAnswerById(question.getIdQuestion(), bundle.getSelectedAnswer()));
					break;
				}
			}

			if (!isFound) {
				System.out.println("No answer found for question: " + question.getQuestiontext());
			}
		}

		return results;
	}


	@Override
	public void publishQuiz(Quiz quiz) {
//		int count = iQuestionSerivce.countValidQuestionsInQuiz(quiz);
//
//		if (count > 0) {
//			quiz.setIsPublished(true);
//			quizRepository.save(quiz);
//		} else {
//			throw new ActionRefusedException("The quiz doesn't have any valid questions");
//		}
	}
	/*******************************************************************************************************************/
	

	private void checkAndUpdateQuestionValidity(Integer idQuiz, boolean newState) {
		Quiz quiz = find(idQuiz);
		if (!quiz.getIsPublished()) {
			quiz.setIsPublished(newState);;
			addQuiz(quiz);
		}
	}
	
	
	
    private void checkQuestionInitialization(Integer idQuiz, int count, Question newquestion) {
		
		checkAndUpdateQuestionValidity(idQuiz, true);
		
	}
	
	private Question updateAndSaveQuestion(Question question, Integer idQuiz, int count) {
		
		Quiz quiz = find(idQuiz);
		Integer s=count + 1;
		question.setQuestionorder(s);
		question.setQuiz(quiz);
		return iQuestionSerivce.saveQuestion(question);
		
	}

	@Override
	public Question addQuestionToQuiz(Question question, Integer idQuiz) {
		int count = iQuestionSerivce.countQuestionsInQuiz(idQuiz);
		Question newquestion = updateAndSaveQuestion(question, idQuiz, count);

		checkQuestionInitialization(idQuiz, count, newquestion);

		return newquestion;
	}

	@Override
	public List<Quiz> GetAllquiz() {
		List<Quiz> liste = quizRepository.findAll();
		return liste ;
	}
	
	
}
