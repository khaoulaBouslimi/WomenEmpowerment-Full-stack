package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Sponsor;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

public interface SponsorService {
    Sponsor ajouterParticipant(Sponsor Sponsor);
    List<Sponsor> afficherTousLesParticipants();

    @Service
    class UserDetailsServiceImpl implements UserDetailsService {
      @Autowired
      UserRepository userRepository;

      @Override
      @Transactional
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
      }

    }
}
