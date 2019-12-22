package com.sergiogutierrez.digitalfarmer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping("/")
	public User add(@RequestBody User user) {
		// Force a save in case an id is passed
		user.setId(0);

		service.save(user);

		return user;
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

}
