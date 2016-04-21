package abstractFactory;

import java.sql.*;

public class MySQLConnection extends AbstractSQL {
	private final static String host = "localhost";
	private final static String port = "3306";
	private final static String name = "MySQLDb";
	private final static String user = "root";
	private final static String pass = "root";
	private Connection connection = null;
	private static MySQLConnection instance = null;
	
	private MySQLConnection() {
	}
	
	public static MySQLConnection getInstance() {
		if(instance ==null){
			instance = new MySQLConnection();
		}
		return instance;
	}
	
	public Connection getConnection() { 
       try {
			if(connection == null || connection.isClosed()) {
				StringBuilder url = new StringBuilder("jdbc:mysql://" + host + ":" + port + "/" + name);
				connection = DriverManager.getConnection(url.toString(), user, pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
          
    } 
		
}
