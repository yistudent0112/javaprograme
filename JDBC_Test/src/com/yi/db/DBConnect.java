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
		System.out.println("���ݿ����ӳɹ���");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ�����ʧ�ܡ�");
			e.printStackTrace();
		}
	}
	public static Connection getConn() {
		return conn;
	}
}
