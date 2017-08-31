package com.demo.enums.resp;


/**
 * 
 * @author Administrator
 *
 */
public enum ResponseStatus {

  

    OK(0, "ok"),

    SYS_ERROR(1,"系统错误"),

    NORMAL_ERROR(1,"普通异常"),

    INVALID_ARGS(1,"请求参数不合法"),
    
    UN_SUBSCRIBE(1,"未关注公众号"),
	

	DUP_SEND(1,"重复发送"),
	
	CODE_ERR(1,"验证码不匹配");
	

    private final int code;
    private final String msg;

    private ResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
