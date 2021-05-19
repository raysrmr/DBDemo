package com.rays;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RetriveDemo3 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
				
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Associate ID : ");
		int aid = sc.nextInt();
		Connection con=null;
		PreparedStatement ps =null;
		try {
			Driver d=new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);   // Load a Driver
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aj1415", "root", "raysrmr");	// Connect to a Database
			ps = con.prepareStatement("select aid,t_name,t_city from trainees where aid=?");
			ps.setInt(1, aid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt("aid")+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}else {
				System.out.println("Wrong Associate ID....");
			}			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error :"+e);
		}finally {
			ps.close();
			con.close();
		}

	}
		

}
