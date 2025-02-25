package com.playground.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playground.exceptions.UserAlreadyPresentException;
import com.playground.exceptions.UserNotFoundException;
import com.playground.models.User;
import com.playground.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping("/get/{userId}")
	public ResponseEntity<User> getUser(@PathVariable int userId){
		User user = service.getUser(userId).orElseThrow(()->new UserNotFoundException("User Not found !"));
		return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user){
		if(service.getUser(user.getUserId()).isPresent()) {
			throw new UserAlreadyPresentException("User already present !");
		}
		User newUser= service.createUser(user);
		return new ResponseEntity<>(service.createUser(newUser),HttpStatus.CREATED);
	}
}
