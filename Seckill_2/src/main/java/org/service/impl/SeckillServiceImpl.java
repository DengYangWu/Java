package org.service.impl;

import java.util.Date;

import org.dao.SeckillDao;
import org.entity.Success_Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillServiceImpl {
	@Autowired
	private SeckillDao seckillDao;
	@Autowired
	private Success_Seckill success_Seckill;
	

}
