package mehmetgul.mylib.jdbc;

import mehmetgul.utils.ConfigurationReader1;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JDBCOracle {


	@Test
	public void test() throws SQLException, ClassNotFoundException {

		String url = "jdbc:oracle:thin:@54.152.156.255:1521:xe";
		String username = "hr";
		String password = "hr";
		String query = "select * from employee";
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection connection = DriverManager.getConnection(url, username, password);

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(query);
		//ResultSetMetaData resultSetMetaData = (ResultSetMetaData) statement.executeQuery(query);
		//resultSetMetaData.getColumnCount();

		System.out.println(resultSet);
	}


	@Test
	public void test5() throws SQLException {

		String userName = "hr";
		String passWord = "hr";

		String url = "jdbc:oracle:thin:@54.152.156.255:1521:xe";

		Connection connection = DriverManager.getConnection(url, userName, passWord);
		System.out.println("Connect Succesfully");

		Statement statement = connection.createStatement();
		System.out.println("statement is created");

		ResultSet result = statement.executeQuery("select *from employees");
		System.out.println("Result set is completed");

		String sql0 = "update mehman2 set given_name='Seyfettin' where employee_id=2";
		System.out.println(sql0);
		statement.executeQuery(sql0);
		System.out.println(sql0);
	}


	@Test
	public void test2() {
		try {
			//step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//step2 create  the connection object
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@54.152.156.255:1521:xe", "hr", "hr");

			//step3 create the statement object
			Statement stmt = con.createStatement();

			//step4 execute query
			ResultSet rs = stmt.executeQuery("select * from emp");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

			//step5 close the connection object
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}


	@Test
	public void test4() {

		// https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html#package.description
		// auto java.sql.Driver discovery -- no longer need to load a java.sql.Driver class via Class.forName

		// register JDBC driver, optional since java 1.6
        /*try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

		// Oracle SID = orcl , find yours in tnsname.ora
		try (Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@54.152.156.255:1521:xe", "hr", "hr")) {
			System.out.println("before if");
			if (conn != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}
			System.out.println("after if");

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("this is : " + e);
		}
		System.out.println("this is end");

	}

	@Test
	public void test6() throws SQLException {

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@54.152.156.255:1521:xe", "hr", "hr");

		Statement statement = connection.createStatement();


		ResultSet resultSet = statement.executeQuery("select * from employees");


		while (resultSet.next()) {


			System.out.print(resultSet.getString(1));

			System.out.print(resultSet.getString("first_name"));


		}

	}


	@Test
	public void test9() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@54.152.156.255:1521:xe", "hr", "hr");

		Statement statement = connection.createStatement();


		ResultSet resultSet = statement.executeQuery("select * from countries");

		while (resultSet.next()) {
			System.out.println(resultSet.getString("country_name") + " " + resultSet.getString("country_id"));

		}

	}


	@Test
	public void test10() throws SQLException {

		String userName = ConfigurationReader1.getProperty("userName");
		String passWord = ConfigurationReader1.getProperty("passWord");
		String urlDB = ConfigurationReader1.getProperty("urlDB");

		String query = "Select * from Employees";

		Connection connection = DriverManager.getConnection(urlDB, userName, passWord);

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		//Using List
		List<String> list = new ArrayList<>();

		while (resultSet.next()) {
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");
			String fullName = firstName + " " + lastName;
			list.add(fullName);
		}
		System.out.println(list);
	}


	@Test
	public void test11() throws SQLException {

		String userName = ConfigurationReader1.getProperty("userName");
		String passWord = ConfigurationReader1.getProperty("passWord");
		String urlDB = ConfigurationReader1.getProperty("urlDB");

		String query = "Select * from Employees";

		Connection connection = DriverManager.getConnection(urlDB, userName, passWord);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		Map<String, Integer> map = new LinkedHashMap<>();
		while (resultSet.next()) {
			String firstName = resultSet.getString("first_name");
			int salary = resultSet.getInt("salary");
			map.put(firstName, salary);

			if (salary >= 17000) {
				System.out.println(firstName + " " + salary);
			}

		}
		System.out.println("==============");
		System.out.println(map);
	}


}