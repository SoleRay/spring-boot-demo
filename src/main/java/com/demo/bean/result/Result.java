/**  
 */
package com.demo.bean.result;

/**
 */
public class Result {

	private Integer code; //编码
	private String msg;  //结果说明
	private Object data;//数据
	private Object info; //其它信息
	private Object link;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
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
	public Object getLink() {
		return link;
	}

	public void setLink(Object link) {
		this.link = link;
	}
}
