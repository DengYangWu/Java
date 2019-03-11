package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import main.dao.UserMapper;
import main.pojo.User;
import main.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-dao.xml", "classpath:spring/applicationContext-service.xml" })
public class test {
//	String myDriver="com.mysql.cj.jdbc.Driver";
//	String url="jdbc:mysql://localhost:3306/text?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
//	String user="root";
//	String password="root";
//	@Test
//	public void txt() {
//		try {
//			Class.forName(myDriver);
//			System.out.printf("驱动器加载成功");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			Connection conn=DriverManager.getConnection(url,user,password);
//			System.out.println("数据库连接成功");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		
//		
//	}

	private UserService userService;
	@Test
	public void TestDemo() throws Exception {
		int id=1;
		User u=userService.find(id);
		System.out.println(u);
		
	}
}
