package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectivity {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host="localhost";
		String port="3306";
		String database="demo";
		String username="root";
		String password="root";
		String url="jdbc:mysql://"+host+":"+port+"/"+database;
		System.out.println(url);
		Connection con=DriverManager.getConnection(url, username, password);
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("select * from credentials where username=\"smartyvik35@gmail.com\"");
		while(rs.next()) {
			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("password"));
		}
		int i=smt.executeUpdate("insert into credentials values (\"vikashkum.1011@gmail.com\",\"101289\")");
		System.out.println(i);
		boolean j=smt.execute("select * from credentials where username=\"smartyvik36@gmail.com\"");
		System.out.println(j);

	}

}
