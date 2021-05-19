package com.rays;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDemo2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Associate ID : ");
		int aid = sc.nextInt();
		System.out.println("Enter Trainee Name : ");
		String tName = sc.next();
	//	System.out.println("Enter Age: ");
	//	int tAge = sc.nextInt();
		System.out.println("Enter City :");
		String tCity = sc.next();
		Connection con=null;
		PreparedStatement ps =null;
		try {
			Driver d=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);   // Load a Driver
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aj1415", "root", "raysrmr");	// Connect to a Database
			 ps = con.prepareStatement("insert into trainees (t_name,t_city,aid)values(?,?,?)");  // Create a Query or Statement
			ps.setInt(3, aid);
			ps.setString(1, tName);
			//ps.setInt(3, tAge);
			ps.setString(2, tCity);
			ps.execute();    // Excute the Query or Statement
			System.out.println("Connected....");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error :"+e);
		}finally {
			ps.close();
			con.close();
		}

	}
		

}
