package com.mindtree.universityMaven.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mindtree.universityMaven.dao.UniversityDao;
import com.mindtree.universityMaven.entity.University;
import com.mindtree.universityMaven.exception.DuplicateUniversityNameException;
import com.mindtree.universityMaven.exception.UniversityDaoException;
import com.mindtree.universityMaven.utility.JdbcConnection;

public class UniversityDaoImpl implements UniversityDao {


	public ArrayList<University> insertUniversity(University u) throws UniversityDaoException {

		Connection con = null;
		PreparedStatement stmt = null;
		Statement st = null;
		ArrayList<University> university = new ArrayList<University>();

		try {
			con = JdbcConnection.getConnection();
			String s = "insert into university values(?,?)";
			stmt = con.prepareStatement(s);
			stmt.setInt(1, u.getId());
			stmt.setString(2, u.getName());

			int r = stmt.executeUpdate();

			st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from university");

			if (r != 0) {
				University ui = new University(u.getId(), u.getName());
				university.add(ui);
			} else {
				try {
					throw new DuplicateUniversityNameException();
				} catch (DuplicateUniversityNameException e) {
					System.out.println(e.getMessage());
				}
			}

			JdbcConnection.closingResources(rs);
		} catch (SQLException e) {
			throw new UniversityDaoException("SQL EXCEPTION !!");
		} finally {
			JdbcConnection.colseConnection(con);
			JdbcConnection.closingResources(stmt);
		}

		return university;

	}

	public ArrayList<University> getAllUniverSity() throws UniversityDaoException {

		Connection con = null;
		Statement stmt = null;
		ArrayList<University> universities = new ArrayList<University>();

		try {
			con = JdbcConnection.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from university");

			while (rs.next()) {
				University ui = new University(rs.getInt(1), rs.getString(2));
				universities.add(ui);
			}
			JdbcConnection.closingResources(rs);
		}

		catch (SQLException e) {
			throw new UniversityDaoException("SQL EXCEPTION !!");
		} finally {
			JdbcConnection.colseConnection(con);
			JdbcConnection.closingResources(stmt);
		}

		return universities;

	}

}
