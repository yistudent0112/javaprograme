package com.yi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * 在连接数据库的过程中遇到了不少坑，在这记录一下
 * jdbc连接数据库不成功被网友总结为四个问题
 * 一是：连接URL格式出现了问题(Connection conn=DriverManager.getConnection
 * ("jdbc:mysql://localhost:3306/XX","root","XXXX")
 * 二是：驱动字符串出错(com.mysql.jdbc.Driver)
 * 三是Classpath中没有加入合适的mysql_jdbc驱动
 * 四是不仅要将驱动加入classpath中，而且需要将该jar包加入到java运行环境的外部jar包中
 * 
 * 我遇到的问题是1，我在url地址中往jdbc后面加了//所有就出现了一直驱动无法成功加载的问题
 * 现在使用的mysql 8.0 以上的jar包   是不需要通过反射去加载jar包的，编译环境会自动寻找合适的驱动加载
 * 然后8.0 之后会有时区问题，需要在url中设置好时区，不然会导致时区不同步，出现问题
 */
public class DBConnectorTest {
private static String URL="jdbc:mysql://localhost:3306/yi_test?serverTimezone=GMT%2B8&useSSL=false";
private static String USER="root";
private static String PASSWORD="yi0112";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.加载驱动程序
		//Class.forName("com.mysql.cj.jdbc.Driver");
		//2.获得数据库连接
	Connection con=DriverManager.getConnection(URL, USER, PASSWORD);
		//3.创建statement对象来操作数据库，实现增删改查的功能
Statement stat=con.createStatement();
ResultSet rs=stat.executeQuery(" select * from task_manage");
while(rs.next()) {
	System.out.println(rs.getString("task_name")+","+rs.getString("task_charge"));
}
	}
}
