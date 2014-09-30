package com.webshop.bo;

import java.util.ArrayList;

public class ItemHandler {
	
	public static ArrayList<ItemInfo> getItemByName(String name){
		ArrayList<Item> items=Item.getItemByName(name);
		ArrayList<ItemInfo>itemsCopy = new ArrayList<ItemInfo>();
		for(int i=0;i<items.size();i++){
			itemsCopy.add(new ItemInfo(items.get(i).getId(), items.get(i).getCategory(), items.get(i).getName(), items.get(i).getPrice(), items.get(i).getDescription()));
		}
		
		return itemsCopy;
	}
	
	public static ItemInfo getItemInfoObj(){
		return new ItemInfo();
	}
	
}
