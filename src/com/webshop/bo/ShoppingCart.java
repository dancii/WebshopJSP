package com.webshop.bo;

import java.util.ArrayList;

public class ShoppingCart {

	private static ArrayList<CartItem> items=new ArrayList<CartItem>();
	
	public static void addItem(CartItem item){
		items.add(item);
	}
	
	public static int countItem(){
		return items.size();
	}
	
	public static ArrayList<CartItem> getCartList(){
		return items;
	}
	
	public static void removeItem(int id){
		items.remove(id);
	}
}
