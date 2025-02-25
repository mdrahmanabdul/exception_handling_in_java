package com.playground.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playground.exceptions.UserNotFoundException;
import com.playground.models.User;
import com.playground.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	public User createUser(User user) {
		return repo.save(user);
	}
	
	public Optional<User> getUser(int userId) {
			return repo.findById(userId);
	}
	
	public List<User> getAllUsers(){
		return repo.findAll();
	}
}
