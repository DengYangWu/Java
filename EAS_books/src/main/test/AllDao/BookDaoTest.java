package AllDao;


import com.giit.www.college.dao.BookDao;
import com.giit.www.entity.Book;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BookDaoTest {
    private ApplicationContext applicationContext;
    @Before
    public void setUp(){
        applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    }
    @Test
    public void findBookAll()throws Exception{
        BookDao bookDao=(BookDao)applicationContext.getBean("bookDao");
        List<Book> book=bookDao.findBookAll();
        System.out.println(book);
    }
    @Test
    public void find()throws Exception{
        BookDao bookDao=(BookDao)applicationContext.getBean("bookDao");
        Book book=bookDao.find("大门","12345");
        System.out.println(book);
    }
    @Test
    public void add()throws Exception{
        BookDao bookDao=(BookDao)applicationContext.getBean("bookDao");
        Book book=new Book();
        book.setBook_Title("大门");
        book.setIsbn("12345");
        book.setDate_Of_Printing("2088");
        book.setAuthor("jack");
        book.setPress("无");
        book.setCategory("t");
        Short s=60;
        book.setUnit_Price(s);

        int i=bookDao.add(book);
        System.out.println(i);
    }
}
