package com.nearsoft.task.socialnetwork;

public class PersonBuilder {
	
	private String name;
	
	private String email;
	
	private String aboutMe;
	
	private String phone;
	
	public PersonBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public PersonBuilder setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public PersonBuilder setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
		return this;
	}
	
	public PersonBuilder setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	
	
	public Person build() {
		return new Person(name, email, aboutMe, phone);
	}
}
