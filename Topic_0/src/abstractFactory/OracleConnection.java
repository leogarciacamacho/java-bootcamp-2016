package abstractFactory;

import java.sql.*;

public class OracleConnection extends AbstractSQL {
	private final static String host = "localhost";
	private final static String port = "3306";
	private final static String name = "OracleDb";
	private final static String user = "root";
	private final static String pass = "root";
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
				StringBuilder url = new StringBuilder("jdbc:oracle://" + host + ":" + port + "/" + name);
				connection = DriverManager.getConnection(url.toString(), user, pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
          
    } 
		
}