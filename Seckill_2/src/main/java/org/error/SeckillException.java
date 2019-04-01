package org.error;

/*
 * 秒杀其他异常类
 * */
public class SeckillException extends RuntimeException{
	public SeckillException(String message){
		super(message);
	}
	public SeckillException(String message,Throwable cause) {
		super(message,cause);
	}
}
