package com.demo.controller.base;

import com.demo.bean.result.Result;
import com.demo.enums.resp.ResponseStatus;
import com.demo.exception.DemoException;
import com.demo.util.resp.ResponseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseController {

    private static final Logger logger = LogManager.getLogger(BaseController.class);

    @ExceptionHandler(value = { Exception.class })
    @ResponseBody
    public Result handleException(Exception ex) {
        logger.error(ex);
        return ResponseUtil.setErrResponse(ResponseStatus.SYS_ERROR);
    }

    @ExceptionHandler(value = { DemoException.class })
    @ResponseBody
    public Result handleSmsExceptionEx(DemoException ex) {
        logger.error(ex);
        return ResponseUtil.setErrResponse(ex.getMessage());
    }
}
