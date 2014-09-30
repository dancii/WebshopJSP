package com.webshop.bo;

import java.util.ArrayList;

import com.webshop.db.ItemDB;

public class Item {
	
	private int id;
	private String category;
	private String name;
	private float price;
	private String description;
	
	public Item(int id, String category, String name, float price, String description){
		this.id=id;
		this.category=category;
		this.name=name;
		this.price=price;
		this.description=description;
	}

	public static ArrayList<Item> getItemByName(String name){
		return ItemDB.getItemByName(name);
	}
	
	public int getId(){
		return id;
	}
	
	public String getCategory(){
		return category;
	}
	
	public String getName(){
		return name;
	}
	
	public float getPrice(){
		return price;
	}
	
	public String getDescription(){
		return description;
	}
	
	
}
