package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Complaints;

@Repository

public interface ComplaintsRepository extends JpaRepository<Complaints, Long> {

	
	@Query(value="select mots from dictionnaire", nativeQuery=true)
	List<String> Dictionnaire();

}
