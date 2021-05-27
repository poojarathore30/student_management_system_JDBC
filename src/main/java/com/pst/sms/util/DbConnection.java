package com.pst.sms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    // load driver4
	private static Connection con = null;
	public static Connection getConn() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms\",\"<username>\",\"<password>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return con;
	}
    // get db connection
	// create statement with query
	// execute/save statement
	// get result from DB
	// close connection
}
