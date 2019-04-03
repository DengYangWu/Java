package org.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dao.SeckillDao;
import org.dao.Success_SeckillDao;
import org.dao.cache.SeckillRedis;
import org.dto.Exposer;
import org.dto.SeckillExecution;
import org.dto.SeckillResult;
import org.entity.Seckill;
import org.entity.Success_Seckill;
import org.enumeration.SeckillEnum;
import org.error.RepeatKillException;
import org.error.SeckillCloseException;
import org.error.SeckillException;
import org.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class SeckillServiceImpl implements SeckillService{
	@Autowired
	private SeckillDao seckillDao;
	@Autowired
	private Success_SeckillDao success_SeckillDao;
	@Autowired 
	private SeckillRedis seckillRedis;
    //md5盐值字符串,用于混淆md5
    private final String slat = "asdfasd2341242@#$@#$%$%%#@$%#@%^%^";
	@Override
	public List<Seckill> getSeckillList() {
		// TODO Auto-generated method stub
		return seckillDao.selectSeckillAll(0,1000);
	}
	@Override
	public Seckill getById(long seckillId) {
		// TODO Auto-generated method stub
		return seckillDao.selectById(seckillId);
	}
	@Override
	public Exposer exposerSeckillUrl(long seckillId) {
		// TODO Auto-generated method stub
		//缓存优化
		//访问redis
		Seckill seckill=seckillRedis.getSeckill(seckillId);
		
		if(seckill == null) {
		//访问数据库
			seckill = getById(seckillId);
			if(seckill == null) {
				return new Exposer(false,seckillId);
			}else {
				//放入Redis
				seckillRedis.putSeckill(seckill);
			}
		}
		//判断开始时间和结束时间是否和当前时间匹配
		Date statetime = seckill.getStartTime();
		Date endtime = seckill.getEndTime();
		Date nowtime=new Date();
		
		if(nowtime.getTime() > endtime.getTime() || nowtime.getTime() < statetime.getTime()) {
			return new Exposer(true,seckillId,nowtime.getTime(),statetime.getTime(),endtime.getTime());
		}
		
		//转化特定字符串过程，不可逆
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);

	}
	private String getMD5(long seckillId) {
		// TODO Auto-generated method stub
		String base = seckillId + "/"  + "slat";
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());

        System.out.println("_________________________________md5: " + md5);
        //System.out.println("_________________________________md5: " +md5);
		return md5;
	}
	@Override
	public SeckillExecution seckillExecution(long seckillId,long userPhone,String md5) 
	throws RepeatKillException,SeckillCloseException,SeckillException{
		// TODO Auto-generated method stub
        if (StringUtils.isEmpty(md5) || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException(SeckillEnum.DATA_REWRITE.getStateinfo());
        }
        //执行秒杀逻辑:1.减库存.2.记录购买行为
        Date now=new Date();
        try {
        int insert = success_SeckillDao.insertSuccessKill(seckillId, userPhone);
        if(insert<=0) {
        	//系统异常
        	throw new SeckillException(SeckillEnum.REPEAT_KILL.getStateinfo());
        }else {
        	//减库存
        	int update = seckillDao.killNumber(seckillId, now);
        	if(update <= 0) {
        		//秒杀结束
        		throw new SeckillCloseException(SeckillEnum.END.getStateinfo());
        	}else {
        		//秒杀成功
        		Success_Seckill success_Seckill=success_SeckillDao.selectByIdSeckill(seckillId, userPhone);
        		return new SeckillExecution(seckillId, SeckillEnum.SUCCESS, success_Seckill);
        	}
        	
        }
        }catch(SeckillCloseException e) {
        	throw e;
        }catch(RepeatKillException e1) {
        	throw e1;
        }catch(Exception e2) {
        	System.out.println(e2.getMessage());
            throw new SeckillException("seckill inner error: " + e2.getMessage());
        }

        
	}


	
}
