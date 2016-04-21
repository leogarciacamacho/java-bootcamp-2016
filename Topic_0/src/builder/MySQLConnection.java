package builder;

import java.sql.*;

public class MySQLConnection {
	private static String host;
	private static String port;
	private static String name;
	private static String user;
	private static String pass;
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

	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		MySQLConnection.host = host;
	}

	public static String getPort() {
		return port;
	}

	public static void setPort(String port) {
		MySQLConnection.port = port;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		MySQLConnection.name = name;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		MySQLConnection.user = user;
	}

	public static String getPass() {
		return pass;
	}

	public static void setPass(String pass) {
		MySQLConnection.pass = pass;
	} 
		
}
