package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Sponsor;

public interface SponsorRepository extends JpaRepository<Sponsor, Integer> {
}
