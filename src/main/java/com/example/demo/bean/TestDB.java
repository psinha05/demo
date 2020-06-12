package com.example.demo.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestDB {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/test";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "palam";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
	    Statement stmt = null;
	    Scanner scn = new Scanner(System.in);
	    //String course_code = null, course_desc = null, course_chair = null;

	    try {
	        // STEP 2: Register JDBC driver
	        Class.forName("com.mysql.jdbc.Driver");

	        // STEP 3: Open a connection
	        System.out.print("\nConnecting to database...");
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        System.out.println(" SUCCESS!\n");
	        
	        stmt = conn.createStatement();
	        String sql ="select * from Author";
	        ResultSet rs=stmt.executeQuery(sql);
	        while(rs.next()) {
	        	System.out.println("To Get Data" + rs.getInt(1) + "" + rs.getString(2)+ "" + rs.getString(3));
	        	}
	         } catch(SQLException se) {
	        se.printStackTrace();
	    } catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if(stmt != null)
	                conn.close();
	        } catch(SQLException se) {
	        }
	        try {
	            if(conn != null)
	                conn.close();
	        } catch(SQLException se) {
	            se.printStackTrace();
	        }
	    }
	    System.out.println("Thank you for your patronage!");
	  }
	


	}


