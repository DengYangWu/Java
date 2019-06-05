package AllDao;

import com.giit.www.entity.User;
import com.giit.www.system.dao.UserDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserDaoTest {
    private ApplicationContext applicationContext;
    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    }
    @Test
    public void login()throws Exception{
        UserDao userDao=(UserDao)applicationContext.getBean("userDao");
        User user = userDao.login("admin","123");
        System.out.println(user);
    }
}