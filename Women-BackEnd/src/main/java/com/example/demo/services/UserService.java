package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.User;

public interface UserService {

	

	public User addUser(User user);

	public void deleteUser(Integer id);

	public List<User> getAll();

	public Optional<User> findById( Integer id);
	
	void nbreUserParGenre();
	
	public List<User> findByUserNameOrEmail(String username);
	
	public User updateUser(Integer id , User user);

	

}
