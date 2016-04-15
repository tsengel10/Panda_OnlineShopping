package com.panda.onlineshopping.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panda.onlineshopping.dao.UserDao;
import com.panda.onlineshopping.entities.User;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserDao adminDao;

	@Override
	public User getUserById(int userId) {
		return adminDao.getUserById(userId);
	}

	@Override
	public void createUser(User user) {
		adminDao.createUser(user);
	}

	@Override
	public User updateUser(User user) {
		return adminDao.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		adminDao.deleteUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return adminDao.getAllUsers();
	}

	@Override
	public List<User> getAllAdmins() {
		List<User> admins = new ArrayList<>();
		for (User admin : this.getAllUsers()) {
			if (admin.getUsertype() == 99)
				admins.add(admin);
		}
		return admins;
	}

	@Override
	public User getAdminById(int userId) {
		User admin = this.getUserById(userId);
		if (admin != null && admin.getUsertype() == 99)
			return admin;
		else
			return null;
	}

}
