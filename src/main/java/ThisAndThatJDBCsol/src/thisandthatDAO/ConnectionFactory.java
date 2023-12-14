package ThisAndThatJDBCsol.src.thisandthatDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	//static reference to itself
	private static ConnectionFactory instance = new ConnectionFactory();
	public static final String URL = "jdbc:mysql://localhost/user01_thisandthat";
	public static final String USER = "user01";
	public static final String PASSWORD = "user01";
	public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	//public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	
	
	//private constructor
	private ConnectionFactory() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("ERROR: Unable to connect to database.");
		}
		return connection;
	}	
	
	public static Connection getConnection() {
		return instance.createConnection();
	}
}

