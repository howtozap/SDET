package com.crm.PRATICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	@Test
	public void sampleJDBCExecuteUpdate() throws SQLException {
		Connection con=null;
		try {
			// step 1:register the database
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			
			//step 2:get the connection from database
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
			
			//step3: issue create statement
			Statement st = con.createStatement();
			
			//step 4: 
			//insert into student(table) values(4,'killer','INDIA');
			int result = st.executeUpdate("insert into student values(4,'killer','INDIA');");
			if (result==1) {
				System.out.println("data added succesfully");
			} else {
				System.out.println("data not added");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		finally {
			//step 5: close database
			con.close();
		}
		
	}

}
