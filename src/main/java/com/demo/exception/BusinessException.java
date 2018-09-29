package com.demo.exception;



/**
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 5660370852963326274L;

    private int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message) {
        super(message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
