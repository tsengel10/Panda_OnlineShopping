package com.panda.onlineshopping.dao;

import java.util.List;

import com.panda.onlineshopping.entities.AuthToken;
import com.panda.onlineshopping.entities.User;

public interface IAuthenticationDao {

	public User authenticateUser(User user);

	public AuthToken generateTokenForUser(User user);

	public List<AuthToken> getAllInactiveAuthTokensByUser(User user);

	public AuthToken getActiveAuthTokenByUser(User user);

	public void createAuthToken(AuthToken authToken);

	public void setInactiveAuthToken(AuthToken authToken);

	public boolean isActiveToken(String token);

	public AuthToken getTokenByToken(String token);

}
