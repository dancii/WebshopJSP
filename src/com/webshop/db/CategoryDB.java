package com.webshop.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.webshop.bo.Category;

public class CategoryDB extends Category{
	
	static Connection con = null;
	static ResultSet rs = null;
	static ArrayList<Category> categoryList = null;
	static DBManager dbManager=null;

	public CategoryDB(int id, String category) {
		super(id, category);
		// TODO Auto-generated constructor stub
	}
	
	public static ArrayList<Category> getAllCategories(){
		Statement stmt=null;
		String searchQuery="SELECT * FROM categories";
		categoryList = new ArrayList<Category>();
		
		try{
			dbManager=DBManager.checkInstance();
			con=dbManager.getFreeConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(searchQuery);
			
			while(rs.next()){
				categoryList.add(new Category(rs.getInt("id"),rs.getString("name")));
			}
			//System.out.println(items.get(0).getName());
		}catch(Exception e){
			System.out.println("DB fail CATEGORY");
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
		return categoryList;
	}
	
}
