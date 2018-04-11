package edu.csula.storage.servlet;

import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import edu.csula.models.User;
import edu.csula.storage.UsersDAO;

/**
 * To abstract the storage access from the business layer using HttpSession
 */
public class UsersDAOImpl implements UsersDAO {
	private final HttpSession context;
	protected static final String CONTEXT_NAME = "users";

	public UsersDAOImpl(HttpSession context) {
		this.context = context;
	}

	@Override
	public boolean authenticate(String username, String password) {
		// TODO: check if username/password combination is valid and store the
		//       username/password into the session
		List<User> users = (List<User>)context.getAttribute(CONTEXT_NAME); 	
		for (int i = 0; i < users.size(); i++){
			if((users.get(i).getUsername() == username)&&(users.get(i).getPassword() == password)){
				this.context.setAttribute(CONTEXT_NAME, users);
				return true;
			}
		}
		return false;
	}

	@Override
	public Optional<User> getAuthenticatedUser() {
		// TODO: return the authenticated user if there is any
		return Optional.empty();
	}

	@Override
	public void logout() {
		// TOOD: log user out using `invalidate`
	}
}
