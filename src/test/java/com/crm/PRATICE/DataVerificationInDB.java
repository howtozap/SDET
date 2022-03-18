package com.crm.PRATICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataVerificationInDB {
		@Test
		public void SampleJDBCExecuteQuery() throws SQLException {
			String expResult = "aBcD";
			//step 1 : register the database
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			
			//step 2: get connector from database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
			
			// step 3:issue create statement
			Statement state = con.createStatement();
			
			//step 4: execute query -- Provide table name
			ResultSet result = state.executeQuery("select * from student");
			
			while (result.next()) {
				String actualResult = result.getString(2);
				if (expResult.equalsIgnoreCase(actualResult)) {
					System.out.println(actualResult+" is verified");
					break;
				}	
				
			}
			
		}
}
