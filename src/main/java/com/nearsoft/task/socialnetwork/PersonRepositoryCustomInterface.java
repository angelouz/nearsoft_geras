package com.nearsoft.task.socialnetwork;

import java.util.List;

public interface PersonRepositoryCustomInterface {

	public void addPerson(Person person);
	
	public List<Person> getPeople();

	public long size();
}
