package abstractFactory;

import java.sql.*;

public class OracleSingleton {
	private static String host = "localhost";
	private static String port = "3306";
	private static String name = "OracleDb";
	private static String user = "root";
	private static String pass = "root";
	private Connection connection = null;
	private static OracleSingleton instance = null;
	
	private OracleSingleton() {
	}
	
	public static OracleSingleton getInstance() {
		if(instance ==null){
			instance = new OracleSingleton();
		}
		return instance;
	}
	
	public Connection getConnection() { 
       try {
			if(connection == null) {
				String url = "jdbc:oracle://" + host + ":" + port + "/" + name;
				connection = DriverManager.getConnection(url, user, pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
          
    } 
		
}