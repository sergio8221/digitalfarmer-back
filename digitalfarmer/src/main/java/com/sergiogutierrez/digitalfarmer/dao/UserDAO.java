package com.sergiogutierrez.digitalfarmer.dao;

import java.util.List;

import com.sergiogutierrez.digitalfarmer.entity.User;

public interface UserDAO {

	public List<User> getAll();

	public User getById(int id);

	public void save(User user);

	public void delete(int id);

}
