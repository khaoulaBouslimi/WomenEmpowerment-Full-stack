package com.example.demo.services;

import java.text.ParseException;
import java.util.List;

import com.example.demo.entities.RendezVous;

public interface RendezVousService {

    RendezVous addRdvAndAffecterDoctorAndLoyerAndUser(RendezVous rendezVous,Integer idDoc,Integer idLoyer,Integer id);
    RendezVous updateRdv(Integer idRdv,RendezVous rendezVous);
    void deleteRendezVous(Integer idRdv);
    void deleteAllRdv();
    List<RendezVous> getAllRendezVous();
    RendezVous getRdvById(Integer idRdv);

    void Notification() throws ParseException;


}
