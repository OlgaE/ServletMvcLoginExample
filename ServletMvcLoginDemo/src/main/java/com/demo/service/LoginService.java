package com.demo.service;

public class LoginService {

	public boolean authenticate(String userId, String password){
		
		if((password == null) || password.trim().equals("")){
			return false;
		} 
		
	return true;
	}
}
