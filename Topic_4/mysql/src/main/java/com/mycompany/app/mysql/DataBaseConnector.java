package com.mycompany.app.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DataBaseConnector {
	private final static String host = "localhost";
	private final static String port = "3306";
	private final static String name = "high_school";
	private final static String user = "root";
	private final static String pass = "root";
	private Connection connection = null;
	private static DataBaseConnector instance = null;
	
	private DataBaseConnector() {
		try {
			Class.forName("com.mysql.jdbc.Connection");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static DataBaseConnector getInstance() {
		if(instance ==null){
			instance = new DataBaseConnector();
		}
		return instance;
	}
	
	public Connection getConnection() { 
       try {
			if(connection == null || connection.isClosed()) {
				StringBuilder url = new StringBuilder ("jdbc:mysql://" + host + ":" + port + "/" + name);
				connection = DriverManager.getConnection(url.toString(), user, pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
          
    } 
	
	public ResultSet getQuery(String query) {
		Statement state = null;
		ResultSet result = null;
		try {
			state = (Statement) connection.createStatement();
			result = state.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
