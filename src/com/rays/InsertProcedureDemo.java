package com.rays;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class InsertProcedureDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Associate ID : ");
		int aid = sc.nextInt();
		System.out.println("Enter Trainee Name : ");
		String tName = sc.next();
		System.out.println("Enter Age: ");
		int tAge = sc.nextInt();
		System.out.println("Enter City :");
		String tCity = sc.next();
		Connection con=null;
		CallableStatement cs =null;
		try {
			Driver d=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);   // Load a Driver
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aj1415", "root", "raysrmr");	// Connect to a Database
			 cs = con.prepareCall("{call insertTrainees(?,?,?,?)}");
			cs.setInt(1, aid);
			cs.setString(2, tName);
			cs.setInt(3, tAge);
			cs.setString(4, tCity);			
			cs.execute();  // Excute the Query or Statement
			System.out.println("Inserted....");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error :"+e);
		}finally {
			cs.close();
			con.close();
		}

	}
		

}
