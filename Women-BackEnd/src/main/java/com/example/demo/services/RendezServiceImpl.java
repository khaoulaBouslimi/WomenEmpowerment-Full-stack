package com.example.demo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Doctor;
import com.example.demo.entities.Lawyer;
import com.example.demo.entities.RendezVous;
import com.example.demo.entities.User;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.LawyerRepository;
import com.example.demo.repository.RendezVousRepository;
import com.example.demo.repository.UserRepository;

@Service
public class RendezServiceImpl implements RendezVousService{
    private static final Logger l = LogManager.getLogger(RendezServiceImpl.class);
    @Autowired
    private RendezVousRepository rendezVousRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    LawyerRepository lawyerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Override
    public RendezVous addRdvAndAffecterDoctorAndLoyerAndUser(RendezVous rendezVous, Integer idDoc, Integer idLoyer, Integer id) {
        emailService.send("ala.znaidi@esprit.tn","test email","test msg");
        RendezVous r=rendezVousRepository.save(rendezVous);
        Doctor d=doctorRepository.findById(idDoc).get();
        Lawyer l=lawyerRepository.findById(idLoyer).get();
        User u=userRepository.findById(id).get();
        r.setDoctor(d);
        r.setLawyer(l);
        r.setUserRdv(u);
        rendezVousRepository.save(r);
        return r;
    }

    @Override
    public RendezVous updateRdv(Integer idRdv, RendezVous rendezVous) {
        RendezVous r=rendezVousRepository.findById(idRdv).get();

        if(rendezVous.getDateRendezVous()!=null) r.setDateRendezVous(rendezVous.getDateRendezVous());
        if(rendezVous.getDoctor()!=null)r.setDoctor(rendezVous.getDoctor());
        if(rendezVous.getLawyer()!=null)r.setLawyer(rendezVous.getLawyer());
        if(rendezVous.getUserRdv()!=null)r.setUserRdv(rendezVous.getUserRdv());
        rendezVousRepository.save(r);
        return null;
    }

    @Override
    public void deleteRendezVous(Integer idRdv) {
        rendezVousRepository.deleteById(idRdv);
    }

    @Override
    public void deleteAllRdv() {
        rendezVousRepository.deleteAll();
    }

    @Override
    public List<RendezVous> getAllRendezVous() {
        return rendezVousRepository.findAll();
    }

    @Override
    public RendezVous getRdvById(Integer idRdv) {
        return rendezVousRepository.findById(idRdv).get();
    }

    @Override
    @Scheduled(cron = "*/10 * * * * *")
    public void Notification() throws ParseException {
        Calendar cal = Calendar.getInstance();


        Date oneHourBack = cal.getTime();
           List<RendezVous> rdvs=rendezVousRepository.findAll();
           for (RendezVous r:rdvs){
               String pattern = "yyyy-MM-dd HH:mm";
               SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
               cal.setTime(new Date());
               cal.add(Calendar.HOUR, -1);

                if(simpleDateFormat.format(cal.getTime()).equals(simpleDateFormat.format(r.getDateRendezVous()))){
                    l.info(  emailService.send(r.getUserRdv().getEmail(),"Rendez vous","Bonjour Mr/Mme "+r.getUserRdv().getUsername()+"" +
                            "<br /> Votre rendez vous sera aprés une heure merci de venez chez nous.<br/>Cordialement."));
                }



               l.info(r.getUserRdv().getEmail());
        }


    }
}

