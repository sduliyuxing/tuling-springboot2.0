package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RefactorUserController implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
    public User getUser(@PathVariable Long id) {
		return userRepository.findById(id).get();
    }

}