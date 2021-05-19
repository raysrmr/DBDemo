package com.rays;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class ConnectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=null;
		try {
			Driver d=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);   // Load a Driver
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aj1415", "root", "raysrmr");	// Connect to a Database
			System.out.println("Connected....");
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
