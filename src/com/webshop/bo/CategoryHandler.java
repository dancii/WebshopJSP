package com.webshop.bo;

import java.util.ArrayList;

public class CategoryHandler {
	
	public static ArrayList<CategoryInfo> getAllCategories(){
		ArrayList<Category> categories= Category.getAllCategories();
		//ArrayList<ItemInfo>itemsCopy = new ArrayList<ItemInfo>();
		ArrayList<CategoryInfo> categoriesCopy = new ArrayList<CategoryInfo>();
		for(int i=0;i<categories.size();i++){
			
			categoriesCopy.add(new CategoryInfo(categories.get(i).getId(), categories.get(i).getCategory()));
		}
		categories.clear();
		return categoriesCopy;
	}
	
	

	
	
	
}
