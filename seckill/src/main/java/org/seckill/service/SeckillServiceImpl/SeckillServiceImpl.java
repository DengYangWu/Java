package org.seckill.service.SeckillServiceImpl;

import java.util.List;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dao.cache.RedisDao;
import org.seckill.entity.Seckill;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SeckillServiceImpl implements SeckillService{
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
}
