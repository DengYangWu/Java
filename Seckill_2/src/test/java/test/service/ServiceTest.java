package test.service;

import org.dto.Exposer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * service的测试类
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:spring/spring-dao.xml",
	"classpath:spring/spring-service.xml"})
public class ServiceTest {
	@Autowired
	private SeckillService seckillService;
	
	@Test
	public void TestSelectAll() {
		System.out.println("ListAll:"+seckillService.getSeckillList());
	}
	@Test
	public void TestSelectById() {
		long seckillId=1000;
		System.out.println("getById:"+seckillService.getById(seckillId));
	}
	@Test
	public void TextExposerUrl() {
		long seckillId=1004;
		Exposer exposer=seckillService.exposerSeckillUrl(seckillId);
		System.out.println(exposer);
	}
}
