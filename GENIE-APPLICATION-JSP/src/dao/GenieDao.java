package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Genie;

public class GenieDao {

	public String inertGenie(Genie g) {

		Connection con = null;
		PreparedStatement stmt = null;
		String msg = "";

		try {
			con = JdbcConnection.getConnection();
			String q = "insert into genie values(?,?,?,?,?)";

			stmt = con.prepareStatement(q);

			stmt.setInt(1, g.getId());
			stmt.setString(2, g.getName());
			stmt.setString(3, g.getCategory());
			stmt.setString(4, g.getSeverity());
			stmt.setString(5, g.getDescription());

			int r = stmt.executeUpdate();

			if (r != 0) {
				msg = "Values Inserted !!";
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcConnection.colseConnection(con);
			JdbcConnection.closingResources(stmt);
		}

		return msg;
	}

	public  static List<Genie> getAllGenie() {

		List<Genie> genie = new ArrayList<>();

		Connection con = null;
		Statement stmt = null;

		try {

			con = JdbcConnection.getConnection();
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from genie");

			while (rs.next()) {

				int id = rs.getInt(1);
				String name = rs.getString(2);
				String category = rs.getString(3);
				String severity = rs.getString(4);
				String description = rs.getString(5);

				Genie g = new Genie(id, name, category, severity, description);
				genie.add(g);

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return genie;
	}

	public Genie selectGenie(int id) {
		Genie genie = null;

		Connection con = null;
		Statement stmt = null;

		try {

			con = JdbcConnection.getConnection();
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from genie");

			while (rs.next()) {
				if (rs.getInt(1) == id) {
					String name = rs.getString("name");
					String category = rs.getString("category");
					String severity = rs.getString("severity");
					String description = rs.getString("description");
					genie = new Genie(id, name, category, severity, description);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return genie;
	}

	public boolean updateGenie(int id, String severity) throws SQLException {
		boolean rowUpdated = false;
		
		try {
			Connection con = JdbcConnection.getConnection();

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from genie");

			int f = 0;
			while (rs.next()) {
				if (rs.getInt(1) == id) {
					f++;
				}
			}

			if (f != 0) {
				String sql = "update genie set severity=? where id=?";
				PreparedStatement statement = con.prepareStatement(sql);

				statement.setString(1, severity);
				statement.setInt(2, id);

				rowUpdated = statement.executeUpdate() > 0;

				if (rowUpdated) {
					System.out.println("Updated");
				}

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return rowUpdated;
	}
	
	
	public boolean deleteGenie(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
        		Connection con = JdbcConnection.getConnection();
        		PreparedStatement stmt = con.prepareStatement("delete from genie where id = ?");
        		stmt.setInt(1, id);
            rowDeleted = stmt.executeUpdate() > 0;
        }catch(SQLException e){
        	System.out.println(e.getMessage());
        }
        return rowDeleted;
    }
	
	
	

}
