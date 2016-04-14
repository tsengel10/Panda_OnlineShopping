package com.panda.onlineshopping.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.panda.onlineshopping.entities.User;
import com.panda.onlineshopping.utils.HibernateUtils;

@Repository
public class UserDao implements IUserDao {

	@Autowired
	private HibernateUtils hibernateUtil;

	@Override
	public void createUser(User user) {
		hibernateUtil.create(user);
	}

	@Override
	public User updateUser(User user) {
		return hibernateUtil.update(user);
	}

	@Override
	public void deleteUser(User user) {
		hibernateUtil.delete(user);
	}

	@Override
	public List<User> getAllUsers() {
		return hibernateUtil.fetchAll(User.class);
	}

	@Override
	public User getUserById(int userId) {
		return hibernateUtil.fetchById(userId, User.class);
	}
}
