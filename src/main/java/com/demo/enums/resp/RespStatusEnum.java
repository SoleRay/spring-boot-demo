package com.demo.enums.resp;


/**
 * 
 * @author Administrator
 *
 */
public enum RespStatusEnum {


    /**
     * 一切OK时
     */
    SUCCESS(0, "ok"),

    /**
     * 系统错误，一般不是主动抛出的异常
     */
    SYS_ERROR(1,"系统错误"),

    /**
     * 业务错误，一般有具体的错误信息
     */
    BUS_ERROR(2,"普通异常");
	

    private final int code;
    private final String msg;

    private RespStatusEnum(int code, String msg) {
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
