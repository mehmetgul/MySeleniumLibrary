package mehmetgul.mylib.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

	public static void main(String[] args) throws SQLException {

		String userName="hr";
		String passWord="hr";

		String url="jdbc:oracle:thin:@54.152.156.255:1521:xe";


		Connection connection= DriverManager.getConnection(url,userName,passWord);
		System.out.println("Connect Succesfully");


		Statement statement=connection.createStatement();
		System.out.println("statement is created");


		ResultSet result=statement.executeQuery("select *from mehman");
		System.out.println("Result set is completed");

		String sql1="Update mehman set last_name='abuziddin3' where employee_id=2";
		statement.executeQuery(sql1);
		System.out.println(sql1);






	}
}
