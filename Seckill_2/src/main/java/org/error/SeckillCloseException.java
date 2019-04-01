package org.error;

/*
 * 秒杀关闭异常类
 * */
public class SeckillCloseException extends RuntimeException{
	public SeckillCloseException(String message) {
		super(message);
	}
	public SeckillCloseException(String message,Throwable cause) {
		super(message, cause);
	}
}
