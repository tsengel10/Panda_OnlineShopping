package com.panda.onlineshopping.dao;

import java.util.List;

import com.panda.onlineshopping.entities.User;

public interface IUserDao {

	public void createUser(User admin);

	public User updateUser(User admin);

	public void deleteUser(User admin);

	public List<User> getAllUsers();

	public User getUserById(int adminId);
}
