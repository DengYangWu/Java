package org.seckill.exception;

/*
 * 秒杀关闭异常
 * */
public class SeckillCloseException extends RuntimeException{

	public SeckillCloseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
