package org.dto;

import java.io.Serializable;

/*
 * 秒杀结果类
 * */
//DTO:完成WEB层到Service层的数据传递
//所有的ajax请求的返回类型封装JSON结果
public class SeckillResult<T> implements Serializable  {
	//Java序列化
	private static final long serialVersionUID = -3936895148526393338L;
	//是否秒杀成功
	private boolean success;
	//泛型时间成员变量
    private T data;
    //错误信息
    private String error;
    
    @Override
	public String toString() {
		return "SeckillResult [success=" + success + ", data=" + data + ", error=" + error + ", isSuccess()="
				+ isSuccess() + ", getData()=" + getData() + ", getError()=" + getError() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//构造方法
    public SeckillResult(boolean success,T data) {
    	this.success=success;
    	this.data=data;
    }
    public SeckillResult(boolean success,String error) {
    	this.success=success;
    	this.error=error;
    }
    
}
