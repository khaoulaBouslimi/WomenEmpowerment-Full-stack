package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.ImageT;

@Repository
public interface ImageRep extends JpaRepository<ImageT,Long> {

}
