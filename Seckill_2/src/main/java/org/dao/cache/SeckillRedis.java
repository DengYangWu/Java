	package org.dao.cache;


import org.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/*
 * redis的dao类
 * */
public class SeckillRedis {
	private static final Logger LOG = LoggerFactory.getLogger(SeckillRedis.class);
	//使用jedis来调用redis
	private final JedisPool jedisPool;
	//高效序列化第三方工具类依赖
	private RuntimeSchema<Seckill> schema=RuntimeSchema.createFrom(Seckill.class);
    public SeckillRedis(String ip, int port) {
        jedisPool = new JedisPool(ip, port);
    }
    
    public Seckill getSeckill(long seckillId) {
    	//redis逻辑操作
    	try {
    		//获取jedis资源
    		Jedis jedis=jedisPool.getResource();
    		try {
    		String key="seckill:"+seckillId;
    		//把获取seckillId的值
    		byte[] bytes = jedis.get(key.getBytes());
    		if(bytes!=null) {
    			//空对象
    			Seckill seckill=schema.newMessage();
    			//反序列化方法
    			//seckill被反序列化
    			ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);
    			return seckill;
    		 }
    		}catch (Exception e) {
				e.printStackTrace();
			}finally{
    		jedisPool.close();
    		}
    	}catch(Exception e) {
    		LOG.error(e.getMessage());
    	}
		return null;
    
    }
    
    //把Seckill对象传入Redis中
    public String putSeckill(Seckill seckill) {
    	//set:Object(Seckill)->序列化->byte[] ->发送给redis
    	try {
    	Jedis jedis=jedisPool.getResource();
    	try {
    	String key="seckill:"+seckill.getSeckillId();
    	byte[] bytes=ProtostuffIOUtil.toByteArray(seckill,schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
        //超时缓存
        //int timeOut = 60 * 60;
        String result = jedis.setex(key.getBytes(), 3600, bytes);
        return result;
    	}finally {
    		
    		jedisPool.close();
    		
    	}
    	}catch(Exception e){
    		 LOG.error(e.getMessage());
    	}
    	return null;
    }

}