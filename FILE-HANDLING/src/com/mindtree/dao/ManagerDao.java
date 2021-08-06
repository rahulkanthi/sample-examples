package com.mindtree.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mindtree.entity.Manager;


public class ManagerDao {
	
	public ArrayList<Manager> getManager() {

		Connection c = null;
		Statement stmt = null;
		String userName = "root";
		String password = "root";
		ArrayList<Manager> l = new ArrayList<Manager>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", userName, password);
			stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("select * from manager");
			while (rs.next()) {
				Manager m = new Manager(rs.getInt(1), rs.getString(2), rs.getInt(3));
				l.add(m);
			}
		} catch (SQLException e) {

		} catch (ClassNotFoundException e) {

		}

		return l;
	}


}
