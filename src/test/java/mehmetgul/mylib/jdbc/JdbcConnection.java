package mehmetgul.mylib.jdbc;


import org.testng.annotations.Test;

import java.sql.*;

public class JdbcConnection {

	public JdbcConnection() throws SQLException {
	}

	@Test
	public void jdbcConnect() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3036/emp";

		//Database Username
		String username = "root";

		//Database Password
		String password = "password";

		//Query to Execute
		String query = "select *  from employee;";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from student"); //Store the results

		while (rs.next()) {
			try {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		st.close();
		con.close();
	}
}


