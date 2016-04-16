package com.panda.onlineshopping.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panda.onlineshopping.dao.AuthenticationDao;
import com.panda.onlineshopping.dao.UserDao;
import com.panda.onlineshopping.entities.AuthToken;
import com.panda.onlineshopping.entities.User;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserDao adminDao;
	@Autowired
	private AuthenticationDao authDao;

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

	@Override
	public User authenticateUser(User user) {
		return authDao.authenticateUser(user);
	}

	@Override
	public AuthToken generateTokenForUser(User user) {
		return authDao.generateTokenForUser(user);
	}

	@Override
	public void createAuthToken(AuthToken authToken) {
		authDao.createAuthToken(authToken);
	}

	@Override
	public void setInactiveAuthToken(AuthToken authToken) {
		authDao.setInactiveAuthToken(authToken);
	}

	@Override
	public List<AuthToken> getAllInactiveAuthTokensByUser(User user) {
		return authDao.getAllInactiveAuthTokensByUser(user);
	}

	@Override
	public AuthToken getActiveAuthTokenByUser(User user) {
		return authDao.getActiveAuthTokenByUser(user);
	}

	@Override
	public boolean isActiveToken(String token) {
		return authDao.isActiveToken(token);
	}

	@Override
	public AuthToken getTokenByToken(String token) {
		return authDao.getTokenByToken(token);
	}

}
