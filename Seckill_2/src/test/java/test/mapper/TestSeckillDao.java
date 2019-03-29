package test.mapper;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.dao.SeckillDao;
import org.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * Dao的调试类
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TestSeckillDao {
	/*
	 * 注入Dao的实体依赖
	 * */
	@Resource
	private SeckillDao seckillDao;
	
	@Test
	public void testKillNumber() {
		long id=1004L;
		Date date = new Date();
		int i=seckillDao.killNumber(id, date);
		System.out.println("insert="+i);
	}
	@Test
	public void testselectById() {
		Long id = 1000L;
		Seckill seckill=seckillDao.selectById(id);
		System.out.println(seckill.getName());
	}
	@Test
	public void testselectSeckillAll() {
		List<Seckill> seckill=seckillDao.selectSeckillAll(0, 100);
		for(Seckill kill:seckill) {
			System.out.println("seckill="+kill);
		}
		
	}
	
}
