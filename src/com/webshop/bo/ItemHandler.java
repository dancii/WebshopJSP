package com.webshop.bo;

import java.util.ArrayList;

public class ItemHandler {
	
	public static ArrayList<ItemInfo> getItemByName(String name){
		ArrayList<Item> items=Item.getItemByName(name);
		ArrayList<ItemInfo>itemsCopy = new ArrayList<ItemInfo>();
		for(int i=0;i<items.size();i++){
			
			itemsCopy.add(new ItemInfo(items.get(i).getId(), items.get(i).getCategory(), items.get(i).getName(), items.get(i).getPrice(), items.get(i).getDescription()));
		}
		items.clear();
		return itemsCopy;
	}
	
	public static ArrayList<ItemInfo> getItemByCategory(String categoryName){
		ArrayList<Item> items=Item.getItemByCategory(categoryName);
		ArrayList<ItemInfo> itemsCopy=new ArrayList<ItemInfo>();
		
		for(Item item: items){
			itemsCopy.add(new ItemInfo(item.getId(),item.getCategory(),item.getName(),item.getPrice(), item.getDescription()));
		}
		items.clear();
		return itemsCopy;
	}
	
	public static ItemInfo getItemInfoObj(){
		return new ItemInfo();
	}
	
	public static CartItem getCartItems(int id, String name, float price){
		return new CartItem(id, name, price);
	}
	
}
