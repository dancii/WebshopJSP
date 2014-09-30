package com.webshop.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.webshop.bo.Item;

public class ItemDB extends Item{
	
	static Connection con = null;
	static ResultSet rs = null;
	ArrayList<Item> items=new ArrayList<Item>();

	public ItemDB(int id, String category, String name, float price,String description) {
		super(id, category, name, price, description);
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Item> findItemByName(String name){
		Statement stmt=null;
		
		String searchQuery="SELECT * FROM products WHERE name LIKE '%"+name+"%'";
		try{
			con=DBManager.getConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(searchQuery);
			
			boolean more = rs.next();
			
			while(more){
				items.add(new Item(rs.getInt("id"),rs.getString("category"),rs.getString("name"), rs.getFloat("price"),rs.getString("description")));
			}
			
			
		}catch(Exception e){

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
	               con.close();
	            } catch (Exception e) {
	            
	            }
	            con = null;
	        }
		}
		return items;
	}
	
}
