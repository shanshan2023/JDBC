package com.shan_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * JDBC操作数据库的步骤
 * 	1.注册驱动
 * 			告知JVM使用的是哪一个数据库的驱动
 * 	2.获得连接
 * 			使用JDBC中的类，完成对MySQL数据库的连接
 * 	3.获得语句执行平台
 * 			通过连接对象获取SQL语句的执行者对象
 * 	4.执行sql语句
 * 			使用执行者对象，向我们数据库执行SQL语句
 * 			获取数据库的执行后的结果
 * 	5.处理结果
 * 	6.释放资源
 * 
 * 
 * */
public class JDBCDemo {
	public static void main(String[] args) throws Exception {
		//1.注册驱动，使用反射，将驱动类加入到内容
		//Driver是一个接口，参数传递，MySQL驱动程序中的实现类
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2.获得连接
		//static Connection getConnection(String url, String user, String password) 尝试建立与给定数据库URL的连接。  
		//返回Connection接口实现类，在MySQL驱动程序
		//url：数据库的地址	jdbc:mysql://连接主机IP:端口号/数据库名字
		//user：root
		//password：111111
		String url="jdbc:mysql://localhost:3306/test2";
		String user="root";
		String password="111111";
		Connection connection = DriverManager.getConnection(url, user, password);
		System.out.println(connection);
		
		//3.获取语句执行平台，通过数据库连接对象，获取到SQL语句的执行者对象
		//connection对象调用方法
		//Statement createStatement() 创建一个 Statement对象，用于将SQL语句发送到数据库。 
		Statement statement = connection.createStatement();
		
		//4.执行sql语句
		//通过执行者对象调用的方法执行SQL语句，获取结果
		//int executeUpdate(String sql) 
		//执行给定的SQL语句，这可能是 INSERT ， UPDATE ，或 DELETE语句，或者不返回任何内容，如SQL DDL语句的SQL语句 
		String sql=("insert into student(name,age) values('单明政', 19)");
		int row = statement.executeUpdate(sql);
		System.out.println(row);
		
		
		//释放资源
		statement.close();
		connection.close();
	}

}
