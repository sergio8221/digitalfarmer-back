package com.sergiogutierrez.digitalfarmer.service;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.User;

public interface UserService {

	public List<User> getAll();

	public User getById(int id);

	public void save(User user);

	public void delete(int id);

}
