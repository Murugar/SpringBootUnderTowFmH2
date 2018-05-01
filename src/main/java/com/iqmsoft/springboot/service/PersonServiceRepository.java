package com.iqmsoft.springboot.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonServiceRepository extends JpaRepository<Person, Long> {
	
	List<Person> findAll();
	Person save(Person user);
	List<Person> findByName(String name);
}
