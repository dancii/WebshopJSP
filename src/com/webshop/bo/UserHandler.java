package com.webshop.bo;

public class UserHandler {

	public static String checkIfLegit(String username, String password){
		User legit = User.checkIfLegit(username, password);
		if(legit==null){
			return "Error";
		}
		return legit.getUsername();
	}
	
}
