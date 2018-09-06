package com.yi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * ���������ݿ�Ĺ����������˲��ٿӣ������¼һ��
 * jdbc�������ݿⲻ�ɹ��������ܽ�Ϊ�ĸ�����
 * һ�ǣ�����URL��ʽ����������(Connection conn=DriverManager.getConnection
 * ("jdbc:mysql://localhost:3306/XX","root","XXXX")
 * ���ǣ������ַ�������(com.mysql.jdbc.Driver)
 * ����Classpath��û�м�����ʵ�mysql_jdbc����
 * ���ǲ���Ҫ����������classpath�У�������Ҫ����jar�����뵽java���л������ⲿjar����
 * 
 * ��������������1������url��ַ����jdbc�������//���оͳ�����һֱ�����޷��ɹ����ص�����
 * ����ʹ�õ�mysql 8.0 ���ϵ�jar��   �ǲ���Ҫͨ������ȥ����jar���ģ����뻷�����Զ�Ѱ�Һ��ʵ���������
 * Ȼ��8.0 ֮�����ʱ�����⣬��Ҫ��url�����ú�ʱ������Ȼ�ᵼ��ʱ����ͬ������������
 */
public class DBConnectorTest {
private static String URL="jdbc:mysql://localhost:3306/yi_test?serverTimezone=GMT%2B8&useSSL=false";
private static String USER="root";
private static String PASSWORD="yi0112";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.������������
		//Class.forName("com.mysql.cj.jdbc.Driver");
		//2.������ݿ�����
	Connection con=DriverManager.getConnection(URL, USER, PASSWORD);
		//3.����statement�������������ݿ⣬ʵ����ɾ�Ĳ�Ĺ���
Statement stat=con.createStatement();
ResultSet rs=stat.executeQuery(" select * from task_manage");
while(rs.next()) {
	System.out.println(rs.getString("task_name")+","+rs.getString("task_charge"));
}
	}
}
