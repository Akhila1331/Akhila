package com.packetprep.loginapp.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConncetion {
	public static Connection getDBConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","root");
	return con;
	}


}
