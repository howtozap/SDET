package GenericLibrary;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * This class contains generic method to read data from database
 * @author pradeep
 *
 */
public class DataBaseUtility {
	Connection con=null;

/**
 * This method will register the driver and establish connection with database
 * @throws Throwable 
 */
public void connectToDb() throws Throwable {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dbUsename, IPathConstants.dbPassword);
	
}
public void closeDB() throws Throwable  {
	con.close();
}

/**
 * This method will execute query and return the matching data to the user.
 * @throws SQLException 
 */
public String executeQueryAndGetData(String query,int columnIndex, String expData) throws Throwable {
	String data=null;
	boolean flag = false;
	ResultSet result = con.createStatement().executeQuery(query);
	while (result.next()) {
		data=result.getString(columnIndex);
		if (data.equalsIgnoreCase(expData)) {
			flag=true;
			break;
		}
	}
	if (flag) {
		System.out.println(data+"----> data verified");
	}
	else {
		System.out.println("data not verified");
	}
	return "";
}
}
