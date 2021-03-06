package com.crm.PRATICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
@Test
public void SampleJDBCExecuteQuery() throws SQLException {
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
		System.out.println(result.getString(1)+ " "+result.getString(2)+" "+result.getString(3));
	}
	//step 5: close database
	con.close();
}
}
