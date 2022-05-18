package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.RendezVous;
import com.example.demo.services.RendezVousService;

@RestController
@RequestMapping("/api/rendezVous")

public class RenderVousController {

    @Autowired
    private RendezVousService rendezVousService;



    @GetMapping("all")
    public List<RendezVous> getAllRdv(){
        return  rendezVousService.getAllRendezVous();
    }

    @GetMapping("/{idRdv}")
    public RendezVous getRdVById(@PathVariable Integer idRdv){
        return rendezVousService.getRdvById(idRdv);
    }

    @PutMapping("/{idRdv}")
    public RendezVous updateRdv(@PathVariable Integer idRdv,@RequestBody RendezVous rendezVous){
        return rendezVousService.updateRdv(idRdv,rendezVous);
    }
    @DeleteMapping("/all")
    public String deleteAll(){
         rendezVousService.deleteAllRdv();
        return "All rdv deleted";
    }

    @DeleteMapping("/{id}")
    public  List<RendezVous> deleteById(@PathVariable Integer id){
        rendezVousService.deleteRendezVous(id);
        return this.getAllRdv();
    }

    @PostMapping("add/{idDoc}/{idLoyer}/{idUser}")
    public RendezVous addRdvAndAffectDoctorAndLoyerAndUser(@RequestBody RendezVous rendezVous, @PathVariable Integer idDoc, @PathVariable Integer idLoyer, @PathVariable Integer id){
        return rendezVousService.addRdvAndAffecterDoctorAndLoyerAndUser(rendezVous,idDoc,idLoyer,id);
    }
}
