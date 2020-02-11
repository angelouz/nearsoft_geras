package com.nearsoft.task.socialnetwork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PersonRepository {
	
	Connection connection;
	
	public PersonRepository(Connection connection) {
		this.connection = connection;
	}
	
	public List<Person> getPeople(){
		
		return null;
	}
	
	public void addPerson(Person person) throws Exception {
		try {
			PreparedStatement statement = connection.prepareStatement("insert into person (name,email,about_me,phone) values (?,?,?,?); ");
			statement.setString(1, person.getName());
			statement.setString(2, person.getEmail());
			statement.setString(3, person.getAboutMe());
			statement.setString(4, person.getPhone());
			
			ResultSet rs = statement.executeQuery();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + e);
		}
	}
	
	public int size() {
		int size = 0;
		try {
			PreparedStatement statement = connection.prepareStatement("select count(1) from person");
			ResultSet rs = statement.executeQuery();
			size = rs.getInt(1);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage() + e);
		}
		
		return size;
	}

}
