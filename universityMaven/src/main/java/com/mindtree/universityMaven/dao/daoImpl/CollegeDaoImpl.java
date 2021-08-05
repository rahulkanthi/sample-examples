package com.mindtree.universityMaven.dao.daoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.mindtree.universityMaven.dao.CollegeDao;
import com.mindtree.universityMaven.entity.College;
import com.mindtree.universityMaven.exception.InvalidRatingException;
import com.mindtree.universityMaven.exception.NoSuchUniversityPresentException;
import com.mindtree.universityMaven.exception.UniversityDaoException;
import com.mindtree.universityMaven.utility.JdbcConnection;

public class CollegeDaoImpl implements CollegeDao {

	static Scanner scan = new Scanner(System.in);


	public String insertCollege(College c) throws UniversityDaoException {

		Connection con = null;
		PreparedStatement stmt = null;
		String msg = "";
		int collegeId = 0;

		try {
			con = JdbcConnection.getConnection();

			String str = "insert into college values(?,?,?,?)";
			stmt = con.prepareStatement(str);

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from college");
			
			while (rs.next()) {
				collegeId = rs.getInt(2);
			}
			
			collegeId=collegeId+1;
			
			JdbcConnection.closingResources(rs);
			
			stmt.setInt(1, c.getId());
			stmt.setInt(2, collegeId);
			stmt.setString(3, c.getName());
			stmt.setDouble(4, c.getRating());

			collegeId++;

			int r = stmt.executeUpdate();

			if (r != 0) {
				msg = "College Registration Successful.";
				return msg;
			} else {

			}

		} catch (SQLException e) {
			throw new UniversityDaoException("SQL EXCEPTION !!");
		} finally {
			JdbcConnection.colseConnection(con);
			JdbcConnection.closingResources(stmt);
		}

		return msg;

	}

	public ArrayList<College> getAllCollege() throws UniversityDaoException {
		Connection con = null;
		Statement stmt = null;
		ArrayList<College> colleges = new ArrayList<College>();

		try {
			con = JdbcConnection.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select *  from university,college where university.id=college.universityid");
			while (rs.next()) {
				College clg = new College(rs.getString(2), rs.getInt(1), rs.getInt(4), rs.getString(5),
						rs.getDouble(6));
				colleges.add(clg);
			}
			JdbcConnection.closingResources(rs);
		}

		catch (SQLException e) {
			throw new UniversityDaoException("SQL EXCEPTION !!");
		} finally {
			JdbcConnection.colseConnection(con);
			JdbcConnection.closingResources(stmt);
		}

		return colleges;
	}

	public ArrayList<College> getAllCollegesByUniverstiy() throws UniversityDaoException {
		Connection con = null;
		Statement stmt = null;
		ArrayList<College> CollegesByUniversity = new ArrayList<College>();
		System.out.println("Enter the University ID: ");
		int id = scan.nextInt();
		try {
			con = JdbcConnection.getConnection();
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(
					"select university.name,college.* from university,college where university.id=college.universityid and university.id="
							+ id + " order by college.rating desc;");
			int f = 0;
			while (rs.next()) {
				College clg = new College(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getDouble(5));
				CollegesByUniversity.add(clg);
				f++;
			}
			if (f == 0) {
				try {
					throw new NoSuchUniversityPresentException();
				} catch (NoSuchUniversityPresentException e) {
					System.out.println(e.getMessage());
				}
			}
			JdbcConnection.closingResources(rs);
		}

		catch (SQLException e) {
			throw new UniversityDaoException("SQL EXCEPTION !!");
		} finally {
			JdbcConnection.colseConnection(con);
			JdbcConnection.closingResources(stmt);
		}

		return CollegesByUniversity;
	}

	public ArrayList<College> getAllCollegesByRating() throws UniversityDaoException {
		Connection con = null;
		Statement stmt = null;
		ArrayList<College> CollegesByRating = new ArrayList<College>();
		System.out.println("Enter the Rating: ");
		double rating = scan.nextDouble();
		try {
			con = JdbcConnection.getConnection();
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(
					"select * from university,college where university.id=college.universityid and college.rating>"
							+ rating + "");
			int f = 0;

			while (rs.next()) {
				f++;
				College clg = new College(rs.getString(2), rs.getInt(1), rs.getInt(4), rs.getString(5),
						rs.getDouble(6));
				CollegesByRating.add(clg);
			}
			if (f == 0) {
				try {
					throw new InvalidRatingException();
				} catch (InvalidRatingException e) {
					System.out.println(e.getMessage());
				}
			}
			JdbcConnection.closingResources(rs);
		}

		catch (SQLException e) {
			throw new UniversityDaoException("SQL EXCEPTION !!");
		} finally {
			JdbcConnection.colseConnection(con);
			JdbcConnection.closingResources(stmt);
		}

		return CollegesByRating;
	}

}
