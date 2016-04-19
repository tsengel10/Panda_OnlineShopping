package com.panda.onlineshopping.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.panda.onlineshopping.entities.Address;
import com.panda.onlineshopping.entities.User;
import com.panda.onlineshopping.utils.DateUtils;
import com.panda.onlineshopping.utils.HibernateUtils;
import com.panda.onlineshopping.utils.PasswordUtils;

@Repository
public class UserDao implements IUserDao {

	@Autowired
	private HibernateUtils hibernateUtil;

	public void createUser(User user) {
		user.setRegisteredDate(DateUtils.getCurrentDateTime());
		user.setPassword(PasswordUtils.hashPassword(user.getPassword()));
		hibernateUtil.create(user);
	}

	public User updateUser(User user) {
		return hibernateUtil.update(user);
	}

	public void deleteUser(User user) {
		hibernateUtil.delete(user);
	}

	public List<User> getAllUsers() {
		return hibernateUtil.fetchAll(User.class);
	}

	public User getUserById(int userId) {
		return hibernateUtil.fetchById(userId, User.class);
	}

	public List<Address> getAllAddresses() {
		return hibernateUtil.fetchAll(Address.class);
	}

}
