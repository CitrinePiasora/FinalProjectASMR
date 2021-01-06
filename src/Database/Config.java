package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
	private static Connection MySQLConfig;
        
	public static Connection ConfigDB() throws SQLException {
		try {	
			String url = "jdbc:mysql://localhost:3306/asmr";
			String user = "root";
			String password = "";
			
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			MySQLConfig = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Successful");
			
		} catch(SQLException e) {
			System.out.println("An error has occured!");
			e.printStackTrace();
			
		}
		
		return MySQLConfig;
	}
}