/**  
 * @Title: Result.java
 * @Package com.globalvillage.bg.baseUtils
 * @Description: TODO
 * @author likeke
 * @date 2016年5月17日
 */
package com.demo.bean.result;

/**
 * ClassName: Result 
 * @Description: TODO
 * @author SoleRay
 * @date 2017年07月14日
 * @version 1.0
 */
public class Result<T> {

	private int code; //编码

	private String msg;  //结果说明

	private T data;//数据


	public Result(int code, String msg) {
		this(code,msg,null);
	}

	public Result(int code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
