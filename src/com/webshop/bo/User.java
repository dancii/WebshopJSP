package com.webshop.bo;

import com.webshop.db.UserDB;

public class User {

	private int id;
	private String username;
	private String password;
	private String email;
	private String name;
	private String lastname;
	
	public User(int id, String username, String password, String email, String name, String lastname){
		this.id=id;
		this.username=username;
		this.password=password;
		this.email=email;
		this.name=name;
		this.lastname=lastname;
	}
	
	public static User checkIfLegit(String username, String password){
		return UserDB.checkIfLegit(username, password);
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	
}
