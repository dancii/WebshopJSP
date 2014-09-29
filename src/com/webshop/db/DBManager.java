package com.webshop.db;

import java.sql.*;
import java.util.*;

public class DBManager {

	static Connection con;
	static String url;
	
	public static Connection getConnection(){
		url = "jdbc:mysql://178.78.213.33/c2lab_2";
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, "c2lab_2", "o3U5ZyBQ");
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	
}
