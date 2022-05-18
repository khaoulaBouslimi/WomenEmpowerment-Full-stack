package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Sponsor;
import com.example.demo.services.SponsorService;

@RestController
@RequestMapping("/api/sponsor")
public class SponsorController {
    @Autowired
    private SponsorService sponsorService;


    @GetMapping("/all")
    public List<Sponsor> getAllSponsors(){
        return sponsorService.afficherTousLesParticipants();
    }

    @PostMapping("/add")
    public List<Sponsor> ajouterSponsor(@RequestBody Sponsor sponsor){
        sponsorService.ajouterParticipant(sponsor);
        return this.getAllSponsors();
    }
}
