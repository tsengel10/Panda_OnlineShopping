package com.panda.onlineshopping.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.panda.onlineshopping.entities.AuthToken;
import com.panda.onlineshopping.entities.User;
import com.panda.onlineshopping.utils.HibernateUtils;
import com.panda.onlineshopping.utils.PasswordUtils;

@Repository
public class AuthenticationDao implements IAuthenticationDao {

	@Autowired
	private HibernateUtils hibernateUtil;

	@Override
	public User authenticateUser(User user) {
		String query = "from User where username = '" + user.getUsername() + "'";
		List<User> dbUsers = hibernateUtil.runSelectQueryList(query);
		if (!dbUsers.isEmpty()) {
			for (User iterUser : dbUsers) {
				if (PasswordUtils.checkPassword(user.getPassword(), iterUser.getPassword())) {
					return iterUser;
				}
			}
		}
		return null;
	}

	@Override
	public AuthToken generateTokenForUser(User user) {
		AuthToken authToken = new AuthToken();
		UUID uuid = UUID.randomUUID();
		authToken.setIsActive(1);
		authToken.setToken(uuid.toString());
		authToken.setUserId(user.getUserid());
		return authToken;
	}

	@Override
	public void createAuthToken(AuthToken authToken) {
		hibernateUtil.create(authToken);
	}

	@Override
	public void setInactiveAuthToken(AuthToken authToken) {
		authToken.setIsActive(0);
		hibernateUtil.update(authToken);
	}

	@Override
	public List<AuthToken> getAllInactiveAuthTokensByUser(User user) {
		String query = "from AuthToken where userid = " + user.getUserid() + " and isActive = 0";
		List<AuthToken> tokens = hibernateUtil.runSelectQueryList(query);
		System.out.println("--------Token size: " + tokens.size());
		return tokens;
	}

	@Override
	public AuthToken getActiveAuthTokenByUser(User user) {
		String query = "from AuthToken where userid = " + user.getUserid() + " and isActive = 1";
		AuthToken dbToken = (AuthToken) hibernateUtil.runSelectQuery(query);
		if (dbToken != null) {
			return dbToken;
		}
		return null;
	}

	@Override
	public boolean isActiveToken(String token) {
		String query = "from AuthToken where token = '" + token + "' and isActive = 1";
		AuthToken dbToken = (AuthToken) hibernateUtil.runSelectQuery(query);
		if (dbToken != null) {
			return true;
		}
		return false;
	}

	@Override
	public AuthToken getTokenByToken(String token) {
		String query = "from AuthToken where token = '" + token + "'";
		AuthToken dbToken = (AuthToken) hibernateUtil.runSelectQuery(query);
		if (dbToken != null) {
			return dbToken;
		}
		return null;
	}
}
