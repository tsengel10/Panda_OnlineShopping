package com.panda.onlineshopping.services;

import java.util.List;

import com.panda.onlineshopping.entities.User;

public interface IUserService {

	public User getUserById(int userId);

	public void createUser(User user);

	public User updateUser(User user);

	public void deleteUser(User user);

	public List<User> getAllUsers();

	public User getAdminById(int userId);

	public List<User> getAllAdmins();

}
