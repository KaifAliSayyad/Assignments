package com.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;


public class DatabaseOperations {
	public static JdbcRowSet rs = null;
	private static final String url = "jdbc:postgresql://localhost:5432/netbanking";
	private static final String uname = "postgres";
	private static final String password = "tiger";

	static {
    	try {
			rs = RowSetProvider.newFactory().createJdbcRowSet();
	        rs.setUrl(url);
	        rs.setUsername(uname);
	        rs.setPassword(password);
		}catch(Exception e) {
			System.out.println("There was an error connecting to the database..Try Again later!");
			e.printStackTrace();
		}
    }
	
	public static JdbcRowSet getConnection() {
		return rs;
	}
	
	public static void closeConnection() {
		try {
			rs.close();			
		}catch(Exception e) {
			System.out.println("Error closing the connection...");
			e.printStackTrace();
		}
	}
	
	public static User login(String id, String pass) throws Exception {
		User obj = new User();
		rs.setCommand("select * from customer where id = '"+id+"'");
		rs.execute();
		String name = "";
		String passFromDb = "";
		while(rs.next()) {
			name = rs.getString(2);
			passFromDb = rs.getString(3);
		}
		if(name.length() == 0) {
			throw new NullPointerException();		//Invalid Customer ID
		}else {
			if(pass.equals(passFromDb)) {
				obj.setName(name);
				obj.setPassword(pass);
				obj.setId(id);
				return obj;
			}else {
				throw new InputMismatchException();			//Invalid Password
			}
		}
	}
	
	public static void register(User u) throws Exception{
		rs.setCommand("select * from customer where id = '"+u.getId()+"'");
		rs.execute();
		String check = "";
		while(rs.next()) check = rs.getString(1);
		if(check.length() == 0) {
			rs.moveToInsertRow();
			rs.updateString("id", u.getId());
			rs.updateString("name", u.getName());
			rs.updateString("password", u.getPassword());
			rs.insertRow();
		}else {
			throw new NullPointerException();		//user already present
		}
	}
	
	public static Map<String, User> getUsersMap() {
		Map<String, User> users = new HashMap<>();
		try {
			rs.setCommand("select * from customer");
			rs.execute();
			int index = 0;
			while(rs.next()) {
				users.put(String.valueOf(index), User.getObject(rs.getString(1), rs.getString(2), rs.getString(3)));
				index++;
			}
			return users;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
}
