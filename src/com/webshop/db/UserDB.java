package com.webshop.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.webshop.bo.User;

public class UserDB extends User{
	
	static Connection con = null;
	static ResultSet rs = null;
	static UserDB userdb=null;
	static DBManager dbManager=null;
	
	public UserDB(int id, String username, String password, String email, String name, String lastname){
		super(id, username,password,email,name,lastname);
	}
	
	public static UserDB checkIfLegit(String username, String password){
		Statement stmt=null;
		
		String searchQuery="SELECT * FROM users WHERE username='"+username+"' AND password='"+password+"'";
		try{
			dbManager=DBManager.checkInstance();
			con=dbManager.getFreeConnection();
			stmt=con.createStatement();
			rs=stmt.executeQuery(searchQuery);
			
			boolean more = rs.next();
			
			if(!more){
				userdb=null;
			}else if(more){
				userdb=new UserDB(rs.getInt("id"),rs.getString("username"),rs.getString("password"), rs.getString("email"),rs.getString("name"),rs.getString("lastname"));
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
	            	dbManager.returnBusyConnection(con);
	            } catch (Exception e) {
	            
	            }
	            con = null;
	        }
		}
		return userdb;
	}
}
