package com.demo.exception;

import com.demo.bean.result.ResultCode;

/**
 * Created by Administrator on 2017-8-12.
 */
public class SignException extends BusinessException {

    public SignException(ResultCode resultCode) {
        super(resultCode);
    }
}
