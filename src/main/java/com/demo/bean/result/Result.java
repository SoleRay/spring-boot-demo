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
public class Result {

	private int code; //编码

	private String msg;  //结果说明

	private Object data;//数据

	private Object info; //其它信息

	public Result(int code, String msg) {
		this(code,msg,null);
	}

	public Result(int code, String msg, Object data) {
		this(code,msg,data,null);
	}

	public Result(int code, String msg, Object data, Object info) {
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.info = info;
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

	public void setData(Object data) {
		this.data = data;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}
}
