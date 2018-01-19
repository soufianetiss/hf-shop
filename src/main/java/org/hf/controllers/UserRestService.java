package org.hf.controllers;

import java.util.Collection;
import java.util.List;

import org.hf.entities.User;
import org.hf.metier.UserMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/users")
public class UserRestService {
	@Autowired
	UserMetier userMetier;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public List<User> listUser(){
		List<User> listUser=userMetier.findAll();
		System.out.println(listUser);
		return listUser;
	}
	@RequestMapping(value="",method=RequestMethod.POST)
	public void signUp(@RequestBody User user){
		userMetier.signUp(user);
	}
	
}
