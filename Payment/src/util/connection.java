package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class connection {
	public Connection con;

	public connection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/paf_payment", "root", "");
			if (conn != null) {
				System.out.println("Database Connection Successful");
				con = conn;
			} else {
				System.out.println("Database Connection Failed");
			}

		} catch (Exception e) {
			System.out.println("Database Connection Failed");

		}
	}

	public Connection getCon() {
		return con;
	}

	public ResultSet getRs(String qry) throws SQLException {
		Statement st = getSt();
		ResultSet rs = st.executeQuery(qry);
		return rs;
	}

	public PreparedStatement getPs(String sql) throws SQLException {
		PreparedStatement ps = con.prepareStatement(sql);
		return ps;
	}

public Statement getSt() throws SQLException {
	Statement st = con.createStatement();
	return st;
	}
}
