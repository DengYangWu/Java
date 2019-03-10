package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import main.mapper.UserMapper;
import main.service.UserService;


public class test {
	String myDriver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/text?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	String user="root";
	String password="root";
	@Test
	public void txt() {
		try {
			Class.forName(myDriver);
			System.out.printf("驱动器加载成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection conn=DriverManager.getConnection(url,user,password);
			System.out.println("数据库连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
