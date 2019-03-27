package org.seckill.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

//DTO:完成WEB层到Service层的数据传递
//所有的ajax请求的返回类型封装JSON结果

public class SeckillResult<T> implements Serializable {

    @Override
	public String toString() {
		return "SeckillResult [success=" + success + ", data=" + data + ", error=" + error + ", isSuccess()="
				+ isSuccess() + ", getData()=" + getData() + ", getError()=" + getError() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	private static final long serialVersionUID = -3936895148526393338L;

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

	private boolean success;

    private T data;

    private String error;

    public SeckillResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public SeckillResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

}