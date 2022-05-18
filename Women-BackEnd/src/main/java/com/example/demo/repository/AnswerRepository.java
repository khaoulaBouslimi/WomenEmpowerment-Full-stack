package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Answer;



@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
	
	@Query("select a FROM Answer a JOIN a.question q WHERE q.idQuestion = :idQuestion ORDER BY a.answerorder DESC")
	List<Answer> findAnswersByQuestionOrderByOrderAsc(@Param("idQuestion") int idQuestion);
	
	@Query("SELECT COUNT(*) FROM Answer WHERE question.idQuestion = :idQuestion  ")
	int countByQuestion(@Param("idQuestion") int idQuestion);

}
