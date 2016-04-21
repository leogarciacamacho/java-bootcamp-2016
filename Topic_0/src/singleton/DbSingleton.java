package singleton;

import java.sql.*;

public class DbSingleton {
	private static String host = "localhost";
	private static String port = "3306";
	private static String name = "javaDb";
	private static String user = "root";
	private static String pass = "root";
	private Connection connection = null;
	private static DbSingleton instance = null;
	
	private DbSingleton() {
	}
	
	public static DbSingleton getInstance() {
		if(instance ==null){
			instance = new DbSingleton();
		}
		return instance;
	}
	
	public Connection getConnection() { 
       try {
			if(connection == null) {
				String url = "jdbc:mysql://" + host + ":" + port + "/" + name;
				connection = DriverManager.getConnection(url, user, pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
          
    } 
		
}
