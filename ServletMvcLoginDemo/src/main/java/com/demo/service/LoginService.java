package com.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.demo.model.Person;

public class LoginService {

	Map<String, Person> people;
	
	public LoginService(){
		
		people = new HashMap<String, Person>();
		
		Person person = new Person();
		person.setFirstname("tom");
		person.setLastname("larsen");
		
		people.put("a12", person);
	}
	
	public boolean authenticate(String userId, String password){
		
		if((password == null) || password.trim().equals("")){
			return false;
		} 
		
	return true;
	}
	
	public Person getPersonById(String id){
		return people.get(id);
	}
}
