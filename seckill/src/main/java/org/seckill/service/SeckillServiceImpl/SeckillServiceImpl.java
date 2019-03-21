package org.seckill.service.SeckillServiceImpl;

import java.util.Date;
import java.util.List;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dao.cache.RedisDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

public class SeckillServiceImpl implements SeckillService{
	//日志API对象
	private static final Logger LOG = LoggerFactory.getLogger(SeckillServiceImpl.class);
	
	@Autowired
	private	SeckillDao seckillDao;
	@Autowired
	private RedisDao redisDao;
	@Autowired
	private SuccessKilledDao successKilledDao;
	
	//md5盐值字符串,用于混淆md5
    private final String slat = "asdfasd2341242@#$@#$%$%%#@$%#@%^%^";
    
    @Override
    public List<Seckill> getSeckillList(){
    	return seckillDao.queryAll(0,1000);
    }
    @Override
    public Seckill getById(Long seckillId) {
        return seckillDao.queryById(seckillId);
    }
	@Override
	public Exposer exportSeckillUrl(Long seckillId) {
		// TODO Auto-generated method stub
		Seckill seckill=seckillDao.queryById(seckillId);
		if(seckill==null) {
			return new Exposer(false,seckillId);
		}
		Date startTime=seckill.getStartTime();
		Date endTime=seckill.getEndTime();
		//系统当前时间
		Date nowTime=new Date();
		if(nowTime.getTime()<startTime.getTime()
				||nowTime.getTime()>endTime.getTime()) {
			return new Exposer(false,seckillId,nowTime.getTime(),startTime.getTime(),endTime.getTime());
		}
		//转化特定字符串的过程，它是不可逆
		String md5=getMD5(seckillId);
		return new Exposer(true,md5,seckillId);
	}
	private String getMD5(long seckillId) {
		String base = seckillId + "/" + slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());	
		return md5;
	}
	@Override
	public SeckillExecution executeSeckill(Long seckillId, Long userPhone, String md5)
			throws SeckillException,RepeatKillException,SeckillCloseException {
		// TODO Auto-generated method stub
		if(md5 == null || md5.equals(getMD5(seckillId))) {
			throw new SeckillException("seckill data rewrite"); //秒杀的数据重复了
		}
		try {
		Date nowTime = new Date();
		//秒杀的业务逻辑:减库存+记录购买行为
		int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
		if(updateCount<=0) {
			//没有更新到记录,秒杀结束
			throw new SeckillCloseException("seckill is closed");
		}else {
			//记录购买行为
			int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
			//唯一：seckillId，userPhone
			if(insertCount<=0) {
				throw new RepeatKillException("seckill repeated");
			}else {
				//秒杀成功
				SuccessKilled successKill=successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
				return new SeckillExecution(seckillId,SeckillStatEnum.SUCCESS,successKill);
			}
		  }
		}
		catch(SeckillCloseException e1) {
			throw e1;
		}
		catch(RepeatKillException e2) {
			throw e2;
		}
		catch (Exception e) {
			//所有编译器异常，转化位运行期异常
			throw new SeckillException("seckill inner error:"+e.getMessage());
		}
	}
}
