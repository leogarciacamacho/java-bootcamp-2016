package builder;

import java.sql.*;

public class OracleConnection {
	private static String host;
	private static String port;
	private static String name;
	private static String user;
	private static String pass;
	private Connection connection = null;
	private static OracleConnection instance = null;
	
	private OracleConnection() {
	}
	
	public static OracleConnection getInstance() {
		if(instance ==null){
			instance = new OracleConnection();
		}
		return instance;
	}
	
	public Connection getConnection() { 
       try {
			if(connection == null || connection.isClosed()) {
				StringBuilder url = new StringBuilder ("jdbc:oracle://" + host + ":" + port + "/" + name);
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
		OracleConnection.host = host;
	}

	public static String getPort() {
		return port;
	}

	public static void setPort(String port) {
		OracleConnection.port = port;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		OracleConnection.name = name;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		OracleConnection.user = user;
	}

	public static String getPass() {
		return pass;
	}

	public static void setPass(String pass) {
		OracleConnection.pass = pass;
	} 
			
}