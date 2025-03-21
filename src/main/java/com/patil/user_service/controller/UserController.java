package com.patil.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.patil.user_service.entity.UserDetailsEntity;
import com.patil.user_service.repository.UserDetailsRepository;

@RestController
public class UserController {
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("/login")
	public String userLogin() {
		return "Hello World!";
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<String> userRegister(@RequestBody UserDetailsEntity userDetailsEntity) {
		String hashPassword = passwordEncoder.encode(userDetailsEntity.getPassword());
		userDetailsEntity.setPassword(hashPassword);
		userDetailsRepository.save(userDetailsEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body("user created successfully");
	}
	
	@GetMapping("/{id}")
	public String getUserById() {
		return "Hello World!";
	}
	
}
