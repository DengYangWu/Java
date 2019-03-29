package test.mapper;

import javax.annotation.Resource;

import org.dao.Success_SeckillDao;
import org.entity.Success_Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * 秒杀的详情接口测试
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TestSuccessSeckillDao {
	/*
	 * 注入Dao接口依赖
	 * */
	@Resource
	private Success_SeckillDao success_SeckillDao;
	
	@Test
	public void insertSuccessKill() {
		int i=success_SeckillDao.insertSuccessKill(1000,15115450179L);
		System.out.println("insert="+i);
	}
	@Test
	public void selectByIdSeckill() {
		try {
		Success_Seckill success=success_SeckillDao.selectByIdSeckill(1000,15115450179L);
		System.out.println("seckill="+success);
		}catch(Exception e) {
			System.out.println("ERROR="+e);
		}
	}

}
