package org.seckill.service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillServiceImpl.SeckillServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:spring/spring-dao.xml",
	"classpath:spring/spring-service.xml"})
public class ServiceTest {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    /*
     * 根据id查询数据
     * */
    @Test
    public void testGetById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        System.out.println(seckill);
    }

    /*
     * 打印全部数据
     * */
    @Test
    public void testGetSeckillList() throws Exception {
        System.out.println(seckillService.getSeckillList());
    }

    @Test
    public void testSeckillLogic() {

        long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        System.out.println(exposer);
        if (exposer.isExposed()) {

            long phone = 15821739222L;

            String md5 = exposer.getMd5();

            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
                System.out.println(seckillExecution);
            } catch (RepeatKillException e) {
                LOG.error(e.getMessage());
            } catch (SeckillCloseException e) {
                LOG.error(e.getMessage());
            }

        } else {
            LOG.warn(exposer.toString());
        }

    }

    @Test
    public void testExportSeckillUrl() throws Exception {
        long id = 1004;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        System.out.println(exposer);
//      Exposer{exposed=true, md5='9b8082b22ded08718a4255e9f482a80c', seckillId=1000, now=0, start=0, end=0}
    }

    @Test
    public void testExecuteSeckill() {
        long id = 1004;
        long phone = 15821739111L;

        String md5 = "e166d026254be6f288c7de9e55fc1356";

        try {

            SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);

            System.out.println(seckillExecution);

        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }
    
      @Test
      public void textExecuteSeckillProcedure() {
    	  long seckillId = 1004L;
    	  long userPhone = 15115450175L;
    	  Exposer exposer=seckillService.exportSeckillUrl(seckillId);
    	  if(exposer.isExposed()) {
    		  String md5 = exposer.getMd5();
    		  SeckillExecution	execution=seckillService.executeSeckillProcedure(seckillId, userPhone, md5);
    		  LOG.info(execution.getStateInfo());
    		  }
      }
//    @Test
//    public void testExecuteSeckillProcedure() {
//        long seckillId = 1004l;
//        long phone = 15811111122l;
//
//        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
//
//        if (exposer.isExposed()) {
//            String md5 = exposer.getMd5();
//            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
//            System.out.println(execution.getStateInfo());
//        }
//
//    }
}