package Service;

import com.twitter.pojo.Admins;
import com.twitter.servlet.AdminsService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminsServiceText {
    private ApplicationContext applicationContext;
    @Before
    public void setUp()throws Exception{
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/spring-dao.xml",
                "spring/spring-service.xml"});
    }
    @Test
    public void findByName(){
        AdminsService adminsService=(AdminsService)applicationContext.getBean("adminsServiceImpl");
        Admins admins=adminsService.findByName("dyw");
        System.out.println(admins);
    }
}
