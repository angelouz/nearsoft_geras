package com.nearsoft.task.socialnetwork;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository implements PersonRepositoryCustomInterface {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private PersonRepositoryBasicInterface personRepository;

	@Override
	public List<Person> getPeople() {
		return personRepository.findAll();
	}

	@Override
	public long size() {
		return personRepository.count();
	}

	@Override
	public void addPerson(Person person) {
		entityManager.persist(person);
	}

}
