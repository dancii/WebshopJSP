package com.webshop.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.webshop.bo.Item;

public class ItemDB extends Item{
	
	static Connection con = null;
	static ResultSet rs = null;
	static ArrayList<Item> items = null;
	static DBManager dbManager=null;

	public ItemDB(int id, String category, String name, float price,String description) {
		super(id, category, name, price, description);
		// TODO Auto-generated constructor stub
	}
	
	public static ArrayList<Item> getItemByName(String name){
		Statement stmt=null;
		String searchQuery="SELECT * FROM products WHERE name LIKE '%"+name+"%'";
		items = new ArrayList<Item>();
		
		try{
			dbManager=DBManager.checkInstance();
			con=dbManager.getFreeConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(searchQuery);
			
			while(rs.next()){
				items.add(new Item(rs.getInt("id"),rs.getString("category"),rs.getString("name"), rs.getFloat("price"),rs.getString("description")));
			}
			System.out.println(items.get(0).getName());
			
			
			
		}catch(Exception e){
			System.out.println("DB fail ITEM");
		}finally{
		    if (rs != null)	{
	            try {
	               rs.close();
	            } catch (Exception e) {}
	               rs = null;
		    }
		    
		    if (stmt != null) {
	            try {
	               stmt.close();
	            } catch (Exception e) {}
	               stmt = null;
            }
		    
		    if (con != null) {
	            try {
	               dbManager.returnBusyConnection(con);
	            } catch (Exception e) {
	            
	            }
	            con = null;
	        }
		}
		return items;
	}
	
	public static ArrayList<Item> getItemByCategory(String categoryName){
		Statement stmt=null;
		String searchQuery="SELECT * FROM products WHERE category = '"+categoryName+"'";
		items = new ArrayList<Item>();
		
		try{
			dbManager=DBManager.checkInstance();
			con=dbManager.getFreeConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(searchQuery);
			
			while(rs.next()){
				items.add(new Item(rs.getInt("id"),rs.getString("category"),rs.getString("name"), rs.getFloat("price"),rs.getString("description")));
			}
			System.out.println("First Category"+items.get(0).getName());
			
			
			
		}catch(Exception e){
			System.out.println("DB fail CATEGORYNAME");
		}finally{
		    if (rs != null)	{
	            try {
	               rs.close();
	            } catch (Exception e) {}
	               rs = null;
		    }
		    
		    if (stmt != null) {
	            try {
	               stmt.close();
	            } catch (Exception e) {}
	               stmt = null;
            }
		    
		    if (con != null) {
	            try {
	               dbManager.returnBusyConnection(con);
	            } catch (Exception e) {
	            
	            }
	            con = null;
	        }
		}
		return items;
	}
	
}
