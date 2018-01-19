package org.hf.metier;

import java.util.List;

import org.hf.entities.User;

public interface UserMetier {
	public void signUp(User u);
	public User findUserByLogin(String login);
	public List<User> findAll();
	
}
