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

	private String code; //编码

	private String message;  //结果说明

	private T data;//数据

	private Result(ResultCode resultCode) {
		this(resultCode,null);
	}

	private Result(ResultCode resultCode, T data) {
		this.code = resultCode.getCode();
		this.message = resultCode.getMsg();
		this.data = data;
	}

	public static Result success(){
		return new Result(ResultCode.SUCCESS);
	}

	public static Result success(Object data){
		return new Result(ResultCode.SUCCESS,data);
	}

	public static Result failure(ResultCode resultCode){
		return new Result(resultCode);
	}

	public static Result failure(ResultCode resultCode,Object data){
		return new Result(resultCode,data);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
