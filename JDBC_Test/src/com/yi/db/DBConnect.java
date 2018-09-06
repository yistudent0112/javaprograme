package com.yi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private static String URL="jdbc:mysql://localhost:3306/yi_test?serverTimezone=GMT%2B8&useSSL=false";
	private static String USER="root";
	private static String PASSWORD="yi0112";
	private static Connection conn=null;
	static {
		try {
		conn=DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("数据库连接成功。");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接失败。");
			e.printStackTrace();
		}
	}
	public static Connection getConn() {
		return conn;
	}
}
