package com.sergiogutierrez.digitalfarmer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergiogutierrez.digitalfarmer.entity.LoginRequest;
import com.sergiogutierrez.digitalfarmer.entity.User;
import com.sergiogutierrez.digitalfarmer.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping("/")
	public List<User> getAll() {
		return service.getAll();
	}

	@GetMapping("/{userId}")
	public User getById(@PathVariable int userId) {
		User user = service.getById(userId);

		if (user == null) {
			throw new RuntimeException("User id not found - " + userId);
		}

		return user;
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<User> getByEmail(@PathVariable String email) {
		return ResponseEntity.ok().body(service.getByEmail(email));
	}

	@PostMapping("/login/")
	public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
		User userLogin = service.getByEmail(loginRequest.getEmail());

		// If user exists and password matches
		if (userLogin != null && userLogin.getPassword().equals(loginRequest.getPassword())) {
			return ResponseEntity.ok(userLogin);
		}

		// If user doesn't exist or password doesn't match
		return ResponseEntity.badRequest().body(null);
	}

	@PostMapping("/")
	public ResponseEntity<User> add(@RequestBody User user) {
		if(!isValid(user)) {
			return ResponseEntity.badRequest().body(null);
		}
		
		User userCheck = service.getByEmail(user.getEmail());

		// I user already exists
		if (userCheck != null) {
			return ResponseEntity.badRequest().body(null);
		}

		service.save(user);

		return ResponseEntity.ok().body(user);
	}

	@PutMapping("/")
	public User update(@RequestBody User user) {
		service.save(user);

		return user;
	}

	@DeleteMapping("/{userId}")
	public int delete(@PathVariable int userId) {

		User user = service.getById(userId);

		if (user == null) {
			throw new RuntimeException("User id not found - " + userId);
		}

		service.delete(userId);

		return userId;
	}
	
	private boolean isValid(User user) {
		if(user != null) {
			return true;
		}
		
		return false;
	}

}
