package org.hf.metier;

import java.util.List;

import org.hf.dao.UserRepository;
import org.hf.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserMetierImp implements UserMetier{
	@Autowired
	UserRepository userRepository;
	@Override
	public void signUp(User u) {
		// TODO Auto-generated method stub
		if(!userRepository.exists(u.getLogin())){
			userRepository.save(u);
		}else {
			throw new RuntimeException("login already exist");
		}
		
		
	}

	@Override
	public User findUserByLogin(String login) {
		// TODO Auto-generated method stub
		User user=userRepository.findOneByLogin(login);
		return user;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
