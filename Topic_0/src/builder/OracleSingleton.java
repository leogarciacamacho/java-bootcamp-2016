package builder;

import java.sql.*;

public class OracleSingleton {
	private static String host;
	private static String port;
	private static String name;
	private static String user;
	private static String pass;
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

	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		OracleSingleton.host = host;
	}

	public static String getPort() {
		return port;
	}

	public static void setPort(String port) {
		OracleSingleton.port = port;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		OracleSingleton.name = name;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		OracleSingleton.user = user;
	}

	public static String getPass() {
		return pass;
	}

	public static void setPass(String pass) {
		OracleSingleton.pass = pass;
	} 
			
}