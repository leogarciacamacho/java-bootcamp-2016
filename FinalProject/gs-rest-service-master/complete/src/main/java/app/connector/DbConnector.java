package app.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	private final static String host = "localhost";
	private final static String port = "3306";
	private final static String name = "shoppingCart";
	private final static String user = "root";
	private final static String pass = "root";
	private Connection connection = null;
	private static DbConnector instance = null;
	
	private DbConnector() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Connection");
		} catch (ClassNotFoundException e) {
			throw e;
		}
	}
	
	public static DbConnector getInstance() throws ClassNotFoundException {
		if(instance ==null){
			instance = new DbConnector();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException { 
       try {
			if(connection == null || connection.isClosed()) {
				String url = "jdbc:mysql://" + host + ":" + port + "/" + name;
				connection = DriverManager.getConnection(url, user, pass);
			}
		} catch (SQLException e) {
			throw e;
		}
		return connection;
          
	}
}