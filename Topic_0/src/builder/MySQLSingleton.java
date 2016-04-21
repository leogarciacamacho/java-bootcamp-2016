package builder;

import java.sql.*;

public class MySQLSingleton {
	private static String host;
	private static String port;
	private static String name;
	private static String user;
	private static String pass;
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

	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		MySQLSingleton.host = host;
	}

	public static String getPort() {
		return port;
	}

	public static void setPort(String port) {
		MySQLSingleton.port = port;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		MySQLSingleton.name = name;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		MySQLSingleton.user = user;
	}

	public static String getPass() {
		return pass;
	}

	public static void setPass(String pass) {
		MySQLSingleton.pass = pass;
	} 
		
}
