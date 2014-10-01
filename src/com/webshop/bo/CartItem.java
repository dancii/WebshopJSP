package com.webshop.bo;

public class CartItem {
	
	private int id;
	private String name;
	private float price;
	
	public CartItem(int id, String name, float price){
		this.id=id;
		this.name=name;
		this.price=price;
	}
	
	public int getItemId(){
		return id;
	}

	public String getItemName(){
		return name;
	}
	
	public float getItemPrice(){
		return price;
	}
	
}
