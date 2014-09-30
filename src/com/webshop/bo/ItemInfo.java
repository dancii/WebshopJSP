package com.webshop.bo;

public class ItemInfo {

	int id;
	String category;
	String name;
	float price;
	String description;
	
	public ItemInfo(){
		
	}
	
	public ItemInfo(int id, String category, String name, float price, String description){
		this.id=id;
		this.category=category;
		this.name=name;
		this.price=price;
		this.description=description;
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
