package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Genre;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);

	}

	@Override
	public List<User> getAll() {

		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	@Scheduled(cron = "*/30 * * * * *")
	public void nbreUserParGenre() {
		log.info("--- Nombre des Users MASCULIN :" + userRepository.nbreByGenre(Genre.MASCULIN));
		log.info("--- Nombre des Users FEMININ : " + userRepository.nbreByGenre(Genre.FEMININ));

	}

	private List<User> users;

	// Love Java 8
	public List<User> findByUserNameOrEmail(String username) {

		List<User> result = users.stream().filter(x -> x.getUsername().equalsIgnoreCase(username))
				.collect(Collectors.toList());

		return result;

	}

	// Init some users for testing
	@PostConstruct
	private void iniDataForTesting() {

		users = new ArrayList<User>();

		User user1 = new User("mkyong", "password111", "mkyong@yahoo.com");
		User user2 = new User("yflow", "password222", "yflow@yahoo.com");
		User user3 = new User("laplap", "password333", "mkyong@yahoo.com");

		users.add(user1);
		users.add(user2);
		users.add(user3);

	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(Integer id, User user) {
		User u = userRepository.findById(id).get();
		u.setEmail(user.getEmail());
		u.setUsername(user.getUsername());
		u.setGenre(user.getGenre());
		u.setAge(user.getAge());
		u.setDob(user.getDob());
		u.setAdresse(user.getAdresse());
		u.setPhone(user.getPhone());
		userRepository.save(u);
		return user;
	}

}

