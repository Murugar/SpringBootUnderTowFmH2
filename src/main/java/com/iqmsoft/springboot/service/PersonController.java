package com.iqmsoft.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@Autowired
	private PersonServiceRepository repo;
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public Person addUser(@RequestBody Person user) {
		repo.save(user);
		return user;
	}
}
