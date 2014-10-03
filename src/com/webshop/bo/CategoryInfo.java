package com.webshop.bo;

import java.util.ArrayList;


public class CategoryInfo {
	
	private String category;
	private int id;
	
	public CategoryInfo(int id, String category){
		this.id = id;
		this.category=category;
	}
	
	public int getId(){
		return id;
	}
	
	public String getCategory(){
		return category;
	}
}
