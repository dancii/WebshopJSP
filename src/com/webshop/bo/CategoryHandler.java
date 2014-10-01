package com.webshop.bo;

import java.util.ArrayList;

public class CategoryHandler {
	
	public static ArrayList<Category> getAllCategories(){
		ArrayList<Category> categories= Category.getAllCategories();
		//ArrayList<ItemInfo>itemsCopy = new ArrayList<ItemInfo>();
		ArrayList<Category> categoriesCopy = new ArrayList<Category>();
		for(int i=0;i<categories.size();i++){
			
			categoriesCopy.add(new Category(categories.get(i).getId(), categories.get(i).getCategory()));
		}
		categories.clear();
		return categoriesCopy;
	}
	

	
	
	
}
