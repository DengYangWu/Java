package org.seckill.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * 测试文件
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
	/*
	 * 注入Dao实现类依赖
	 * */
	@Resource
	private SeckillDao seckillDao;
	@Test
	public void testQueryById() throws Exception{
		long id = 1000;
		Seckill seckill=seckillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);
	}
	@Test
	public void testQueryAll() throws Exception{
		List<Seckill> seckill=seckillDao.queryAll(0, 100);
		for(Seckill seckills : seckill) {
			System.out.println(seckill);
		}
	
	}
	@Test
	public void testReduceNumber() throws Exception{
		Date killTime =new Date();
		//Long i=1000L;
		int updateCount=seckillDao.reduceNumber(1000L, killTime);
		System.out.println("updateCount="+updateCount);
	}
}
