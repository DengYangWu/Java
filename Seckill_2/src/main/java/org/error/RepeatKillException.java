package org.error;

/*
 * 重复秒杀异常类
 * */
public class RepeatKillException extends RuntimeException{
	public RepeatKillException(String message) {
		super(message);
	}
	public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
