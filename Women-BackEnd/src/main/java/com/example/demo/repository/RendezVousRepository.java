package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.RendezVous;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous,Integer> {

   /// @Query("SELECT D FROM Doctor D ,RendezVous R,User U where D.userDoctor.id=R.userRdv.id and " +
       //     "R.userRdv.id=U.id and D.DateTravail=R.dateRendezVous and D.disponibilte=true")


    List<RendezVous> getRendezVousByDateRendezVous(Date date);
}
