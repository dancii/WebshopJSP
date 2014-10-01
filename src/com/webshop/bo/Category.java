package com.webshop.bo;

import java.util.ArrayList;

import com.webshop.db.CategoryDB;

public class Category {
	
	private String category;
	private int id;
	
	public Category(int id, String category){
		this.id = id;
		this.category=category;
	}

	public static ArrayList<Category> getAllCategories(){
		//System.out.println("Check name 2:" + name);
		return CategoryDB.getAllCategories();
	}
	
	public int getId(){
		return id;
	}
	
	public String getCategory(){
		return category;
	}
}
