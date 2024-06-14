package com.packetprep.loginapp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.packetprep.loginapp.factory.DBConncetion;
import com.packetprep.loginapp.model.Login;

public class UserDAO {
	public static boolean validateUser(Login l) throws ClassNotFoundException, SQLException
	{
	Connection con=DBConncetion.getDBConnection();
	String sql="select email,password from registration where email=? and password=?";
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setString(1,l.getEmail());
	pst.setString(2,l.getPassword());
	ResultSet rs=pst.executeQuery();

	if(rs.next())
		return true;
	else
		return false;

	}
	}
