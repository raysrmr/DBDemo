package com.rays;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetaDataDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			Driver d=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);   // Load a Driver
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aj1415", "root", "raysrmr");	// Connect to a Database
			PreparedStatement st = con.prepareStatement("select * from trainees");
			ResultSetMetaData rsmd = st.getMetaData();
			System.out.println(rsmd.getColumnCount());
			System.out.println("Connected....");
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
