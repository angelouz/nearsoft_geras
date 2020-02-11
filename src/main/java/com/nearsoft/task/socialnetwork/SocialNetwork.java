package com.nearsoft.task.socialnetwork;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nearsoft.task.validators.EmailValidator;
import com.nearsoft.task.validators.PalindromeChecker;

@Component
public final class SocialNetwork {
	
	@Autowired
	private PersonRepository personRepository;

	private SocialNetwork() {
		
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
