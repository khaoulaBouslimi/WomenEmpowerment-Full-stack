package com.example.demo.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Events;
import com.example.demo.entities.Sponsor;
import com.example.demo.entities.User;
import com.example.demo.repository.EventsRepository;
import com.example.demo.repository.SponsorRepository;
import com.example.demo.repository.UserRepository;

@Service
public class EventsServiceImpl implements EventsService{
    @Autowired
    private EventsRepository eventsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SponsorRepository participantRepository;


    @Override
    public List<Events> afficherTousLesEvenements() {
        return eventsRepository.findAll();
    }

    @Override
    public Events afficherEventById(int idEvent) {
        return eventsRepository.findById(idEvent).orElse(null);
    }

    @Override
    public Events afficherEventByDate(Date date) {
        return eventsRepository.getEventsByDate(date);
    }

    @Override
    public Events ajouterEvent(Events events) {
        return eventsRepository.save(events);
    }

    @Override
    public Events modifierEvent(int idEvent,Events events) {
        Events event=eventsRepository.findById(idEvent).orElse(null);

        if(events.getDate()!=null) event.setDate(events.getDate());
        if(events.getEventTopic()!=null) event.setEventTopic(events.getEventTopic());
        if(events.getDescription()!=null) event.setDescription(events.getDescription());
        if(events.getUserEvents()!=null)event.setUserEvents(events.getUserEvents());

        return eventsRepository.save(event);
    }

    @Override
    public List<Events> supprimerEvent(int idEvent) {
        eventsRepository.deleteById(idEvent);
        return this.afficherTousLesEvenements();
    }

    @Override
    public void supprimerTousLesEvenements() {
        eventsRepository.deleteAll();
    }

    @Override
    public List<Events> supprimerAllEventsByDate(Date date) {
        return eventsRepository.deleteAllByDate(date);
    }

    @Override
    public Events affecterUserAEvent(int idEvent, Integer id) {
        Events ev=eventsRepository.findById(idEvent).get();
        User us=userRepository.findById(id).get();
        ev.setUserEvents(us);

        return eventsRepository.save(ev);
    }

    @Override
    public Events affecterParticipantAEvent(int idEvent, List<Integer> idParticipant) {
        Events ev=eventsRepository.findById(idEvent).get();
        List<Sponsor> part=participantRepository.findAllById(idParticipant);
        ev.setSponsors(part);
        return eventsRepository.save(ev);
    }

    @Override
    public Double sommeDonation() {
        return eventsRepository.sommeDonation();
    }

    @Override
    public List<Events> addImgToEventsList(MultipartFile file, List<Long> idEvent) throws IOException {

        List<Events> events=eventsRepository.findAll();
        for (Events ev:events){
            ev.setFileName(file.getOriginalFilename());
            ev.setFileType(file.getContentType());
            ev.setData(file.getBytes());
            eventsRepository.save(ev);
        }
        return events;
    }

    @Override
    public int nbrDonation() {
        return eventsRepository.nbrDonation();
    }


}
