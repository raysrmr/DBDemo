package com.rays;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class ProcedureDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Associate ID :");
		int aid = sc.nextInt();

		try {
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d); // Load a Driver
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aj1415", "root", "raysrmr"); 
			CallableStatement cs = con.prepareCall("{call getTraineesById(?,?,?,?)}");
			cs.setInt(1, aid);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.execute();
			String tName = cs.getString(2);
			int tage = cs.getInt(3);
			String tcity = cs.getString(4);
			System.out.println(tName+"\t"+tage+"\t"+tcity);
			
		} catch (SQLException e) {
			System.out.println("no data found "+e);
		}finally {
			
		}
	}

}
