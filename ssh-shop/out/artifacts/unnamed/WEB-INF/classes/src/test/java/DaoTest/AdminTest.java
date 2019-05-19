package DaoTest;




import com.shop.dao.AdminDao;

import com.shop.dao.impl.AdminDaoImpl;
import com.shop.model.Admin;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

//测试类
public class AdminTest{
    private static AdminDao adminDao;

    public static void main(String[] args)throws Exception{

            Admin admin=adminDao.findOne(1);

    }
}