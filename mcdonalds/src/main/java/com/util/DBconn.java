package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// SingleTon 선언
public class DBconn {
	
	private static Connection connection = null;
	
	private DBconn() {}
	
	public static Connection getConnection(){
		
		if (connection == null) {
			// JDBC Driver	ojdbc6.jar
			String className = "oracle.jdbc.driver.OracleDriver" ;
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "Mc_donald";
			String password = "mc1234";
			try {
				Class.forName(className);
				connection = DriverManager.getConnection(url,user,password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} //if
		
		return connection;
	} //getConnection
	
	// 오버로딩
	public static Connection getConnection(String url, String user, String password){
		
		if (connection == null) {
			String className = "oracle.jdbc.driver.OracleDriver" ;
			try {
				Class.forName(className);
				connection = DriverManager.getConnection(url,user,password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} //if
		
		return connection;
	} //getConnection
	
	public static void close() {
		
		try {
			if (connection != null && connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}//try
		
		// *****
		connection = null;
	} //close
	
} //class
