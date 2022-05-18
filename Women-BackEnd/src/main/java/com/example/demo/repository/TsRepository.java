package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.TrainingSession;

@Repository
public interface TsRepository extends JpaRepository<TrainingSession, Integer> {

}
