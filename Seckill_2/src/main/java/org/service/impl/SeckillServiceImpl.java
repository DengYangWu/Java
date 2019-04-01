package org.service.impl;

import java.util.Date;
import java.util.List;

import org.dao.SeckillDao;
import org.dao.Success_SeckillDao;
import org.dao.cache.SeckillRedis;
import org.dto.Exposer;
import org.dto.SeckillExecution;
import org.entity.Seckill;
import org.entity.Success_Seckill;
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
	public SeckillExecution seckillExecution(long seckillId) {
		// TODO Auto-generated method stub
		
		return null;
	}
	

	
}
