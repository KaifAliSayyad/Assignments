package com.main;

import java.util.InputMismatchException;

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
	
	public static User register(String id, String name, String pass) throws Exception{
		User obj = new User();
		rs.setCommand("select * from customer where id = '"+id+"'");
		rs.execute();
		String check = "";
		while(rs.next()) check = rs.getString(1);
		if(check.length() == 0) {
			rs.moveToInsertRow();
			rs.updateString("id", id);
			rs.updateString("name", name);
			rs.updateString("password", pass);
			rs.insertRow();
			obj.setId(String.valueOf(id));
			obj.setName(name);
			obj.setPassword(pass);
			return obj;
		}else {
			throw new NullPointerException();		//user already present
		}
	}
	
	
}
