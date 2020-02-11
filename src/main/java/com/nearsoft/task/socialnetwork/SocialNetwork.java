package com.nearsoft.task.socialnetwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.nearsoft.task.validators.EmailValidator;
import com.nearsoft.task.validators.PalindromeChecker;

public final class SocialNetwork {
	
	private PersonRepository personRepository;

	private SocialNetwork() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/~/tmp/h2dbs/nearsoft");
			
			personRepository = new PersonRepository(connection);
		} catch (SQLException e) {
			;e.printStackTrace();
		}
	}

	private static final SocialNetwork socialNetwork = new SocialNetwork();

	public static SocialNetwork getInstance() {

		return socialNetwork;
	}

	private final List<Person> people = new LinkedList<Person>();

	public List<Person> getPeople() {
		return people;
	}

	public void addPerson(Person person) {
		if (PalindromeChecker.check(person.getAboutMe()) && EmailValidator.check(person.getEmail())) {
			try {
				this.personRepository.addPerson(person);
				this.people.add(person);
			} catch (Exception e) {
				System.out.println("There was a problem with Person Insertion"+ e.getMessage());
				e.printStackTrace();
			}
			
		}
	}
	
	public int size() {
		return this.people.size();
	}
}
