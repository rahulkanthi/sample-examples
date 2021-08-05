package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/jspexample";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection() 
	{
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}

	public static String colseConnection(Connection connection) {
		String result = "";
		try {
			if (connection != null) {
				connection.close();
				result = "Successfully Closed The Connection.";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public static String closingResources(Statement statement) {
		String result = "";
		try {
			if (statement != null) {
				statement.close();
				result = "Successfully Closed The resources.";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public static String closingResources(ResultSet rs) {
		String result = "";
		try {
			if (rs != null) {
				rs.close();
				result = "Successfully Closed The resources.";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

}
