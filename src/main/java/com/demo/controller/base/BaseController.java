package com.demo.controller.base;

import com.demo.bean.result.Result;
import com.demo.enums.resp.RespStatusEnum;
import com.demo.exception.BusinessException;
import com.demo.exception.SignException;
import com.demo.util.resp.ResponseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



public class BaseController {

    private static final Logger LOG = LogManager.getLogger(BaseController.class);

    /**
     * 所有不是继承BusinessException的异常，都视为系统异常
     */
    @ExceptionHandler(value = { Exception.class })
    @ResponseBody
    public Result handleException(Exception ex) {
        LOG.error(ex);
        return ResponseUtil.setSysErrorResponse();
    }

    /**
     * 所有业务异常都继承BusinessException
     */
    @ExceptionHandler(value = { BusinessException.class })
    @ResponseBody
    public Result handleBusinessException(BusinessException be) {
        LOG.error(be.getMessage(),be);
        if(be.getCode()==0){
            return ResponseUtil.setBusErrorResponse(be.getMessage());
        }else {
            return ResponseUtil.setBusErrorResponse(be.getCode(),be.getMessage());
        }
    }
}
