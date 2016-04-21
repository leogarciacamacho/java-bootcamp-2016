package abstractFactory;

import java.sql.*;

public class MySQLSingleton {
	private static String host = "localhost";
	private static String port = "3306";
	private static String name = "MySQLDb";
	private static String user = "root";
	private static String pass = "root";
	private Connection connection = null;
	private static MySQLSingleton instance = null;
	
	private MySQLSingleton() {
	}
	
	public static MySQLSingleton getInstance() {
		if(instance ==null){
			instance = new MySQLSingleton();
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
