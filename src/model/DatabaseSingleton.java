package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSingleton {
	private static DatabaseSingleton database;
	private static Connection connection;
	
	private DatabaseSingleton(String connection) {
		try {
			this.connection=DriverManager.getConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DatabaseSingleton connectToDatabase(String connection) {
			if(database==null) {
				database= new DatabaseSingleton(connection);
			}
			else {
				try {
					DatabaseSingleton.connection=DriverManager.getConnection(connection);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return database;
		
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
	public static void setConnection(Connection connection) {
		DatabaseSingleton.connection=connection;
	}
}
