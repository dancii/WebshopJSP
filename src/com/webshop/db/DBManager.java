package com.webshop.db;

import java.sql.*;
import java.util.*;

	

public class DBManager {

	private static Connection con;
	private static String url;
	private static DBManager DBManInstance=null;
	private static ArrayList<Connection> freeCons;
	private static ArrayList<Connection> busyCons;
	
	protected DBManager(){
		freeCons=new ArrayList<Connection>();
		busyCons=new ArrayList<Connection>();
		
		for(int i=0;i<=1;i++){
			freeCons.add(createConnection());
		}
		
	}
	
	public Connection createConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			url = "jdbc:mysql://178.78.213.33/c2lab_2";
			return DriverManager.getConnection(url, "c2lab_2", "o3U5ZyBQ");
		} catch (Exception e) {
			System.out.println("Cannot create connection");
			return null;
		}
	}
	
	public Connection getFreeConnection(){
		if(freeCons.isEmpty()){
			busyCons.add(createConnection());
			return busyCons.get(busyCons.size()-1);
		}else{
			busyCons.add(freeCons.remove(0));
			return busyCons.get(busyCons.size()-1);
		}
	}
	
	public static DBManager checkInstance(){
		if(DBManInstance==null){
			DBManInstance=new DBManager();
		}
		return DBManInstance;
	}
	
	public void returnBusyConnection(Connection con){
		Iterator iter = busyCons.iterator();
		int i=0;
		int id=0;
		while(iter.hasNext()){
			if(busyCons.get(i).equals(con)){
				freeCons.add(busyCons.remove(i));
				break;
			}
			i++;
		}
		
	}
	
}
