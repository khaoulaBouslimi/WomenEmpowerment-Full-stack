package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

	
	
	@Query("SELECT COUNT(q.isvalid) FROM Question q WHERE (quiz.idQuiz=?1) and (q.isvalid = true)")
	int countValidQuestionsByQuizAndIsValidTrue(@Param("idQuiz") Integer idQuiz);

	

	@Query("SELECT COUNT(*) FROM Question WHERE quiz.idQuiz = :idQuiz ")
	int countQuestionsInTheQuiz(@Param("idQuiz") Integer idQuiz);


	@Query("select q FROM Question q JOIN q.quiz z WHERE z.idQuiz = :idQuiz ORDER BY q.questionorder ASC")
	List<Question> findQuestionsByQuizOrderByAsc(@Param("idQuiz") Integer idQuiz);



	
	
	@Query("SELECT q FROM Question q JOIN q.quiz z WHERE (z.idQuiz=?1) and (q.isvalid = 1)")
	//@Query(value="SELECT * FROM question q WHERE q.isvalid = 1 and q.quiz_id_quiz= :idQuiz", nativeQuery = true)
	//@Query(value="SELECT * FROM question q where q.idquiz= :idQuiz and q.isvalid=1 ", nativeQuery = true)
	//@Query(value="SELECT * FROM quiz JOIN question on question.idquiz= :id_quiz where question.isvalid=1 ", nativeQuery = true)
	//@Query("select q FROM Question q JOIN q.quiz z where ((z.idQuiz= :id_quiz) and (q.isvalid = 1))")
	List<Question> findValidQuestionsByQuizOrderByOrderAsc(@Param("id_quiz") Integer idQuiz);

	
	
	
	
	
	
	
	
	
	
	
	
	
}
