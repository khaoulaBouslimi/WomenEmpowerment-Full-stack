package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Events;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer> {
    Events getEventsByDate(Date date);
    List<Events> deleteAllByDate(Date date);

    @Query("SELECT sum(P.donation) FROM Sponsor P ")
    Double sommeDonation();

    @Query("SELECT count(P) FROM Events E,Sponsor P join E.sponsors pp where pp=P")
    int nbrDonation();

}