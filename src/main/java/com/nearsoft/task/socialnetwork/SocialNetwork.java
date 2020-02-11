package com.nearsoft.task.socialnetwork;

import java.util.LinkedList;
import java.util.List;

import com.nearsoft.task.validators.EmailValidator;
import com.nearsoft.task.validators.PalindromeChecker;

public final class SocialNetwork {

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
			this.people.add(person);
		}
	}
}
