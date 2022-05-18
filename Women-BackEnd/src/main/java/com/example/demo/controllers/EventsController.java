package com.example.demo.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Events;
import com.example.demo.services.EventsService;

@RestController
@RequestMapping("/api/Events")
public class EventsController {

    @Autowired
    private EventsService eventsService;


    @GetMapping("/all")
    public List<Events> getAllEvents(){
        return eventsService.afficherTousLesEvenements();
    }

    @GetMapping("/{id}")
    public Events getEventById(@PathVariable int id){
        return eventsService.afficherEventById(id);
    }
    @GetMapping("affectUser/{idEvent}/{id}")
    public Events affecterUserAEvent(@PathVariable int idEvent,@PathVariable Integer id){
        return eventsService.affecterUserAEvent(idEvent,id);
    }

    @GetMapping("affectParticipant/{idEvent}/{idParticipant}")
    public Events affecterParticipantAEvent(@PathVariable int idEvent,@PathVariable List<Integer> idParticipant){
        return eventsService.affecterParticipantAEvent(idEvent,idParticipant);
    }

    @GetMapping("/byDate")
    public Events getEventByDate(@PathParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return eventsService.afficherEventByDate(date);
    }



    @DeleteMapping("/{id}")
    public List<Events> deleteEventById(@PathVariable int id){
        return eventsService.supprimerEvent(id);
    }

    @DeleteMapping("/byDate")
    public List<Events> deleteEventById(@PathParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return eventsService.supprimerAllEventsByDate(date);
    }

    @DeleteMapping("/all")
    public String deleteAllEvents(){
        eventsService.supprimerTousLesEvenements();
        return "Tous les évenement a été supprimer !!";
    }

    @PostMapping("/add")
    public Events ajouterEvent(@RequestBody Events events){
        return eventsService.ajouterEvent(events);
    }

    @PutMapping("/{id}")
    public Events updateEventById(@PathVariable int id,@RequestBody Events events){
        return eventsService.modifierEvent(id,events);
    }
    @RequestMapping(value = "/addImgEventsList",method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<Events> addImgToEventsList(@RequestPart("file") MultipartFile image, @RequestParam List<Long> idRec)throws IOException {
        return eventsService.addImgToEventsList(image,idRec);
    }
    @GetMapping("/Donations")
    public Double sommeDonation(){
        return eventsService.sommeDonation();
    }

    @GetMapping("/NbrDonations")
    public int NbrDonation(){
        return eventsService.nbrDonation();
    }

}
