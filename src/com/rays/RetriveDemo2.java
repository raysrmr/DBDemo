package com.rays;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RetriveDemo2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
				
		Connection con=null;
		Statement st =null;
		try {
			Driver d=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);   // Load a Driver
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aj1415", "root", "raysrmr");	// Connect to a Database
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select aid,t_name,t_city from trainees");
			while(rs.next()) {
				System.out.println(rs.getInt("aid")+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
			System.out.println("Connected....");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error :"+e);
		}finally {
			st.close();
			con.close();
		}

	}
		

}
