package com.demo.controller.exception;

import com.demo.bean.result.Result;
import com.demo.bean.result.ResultCode;
import com.demo.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@Slf4j
//@ControllerAdvice
public class OldExceptionController {


//    /**
//     * 处理所有不可知异常
//     *
//     * @param e 异常
//     * @return json结果
//     */
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Result handleException(Exception e) {
//        // 打印异常堆栈信息
//        log.error(e.getMessage(), e);
//        return Result.failure(ResultCode.UNKNOWN_ERROR);
//    }
//
//    /**
//     * 处理所有业务异常
//     *
//     * @param e 业务异常
//     * @return json结果
//     */
//    @ExceptionHandler(BusinessException.class)
//    @ResponseBody
//    public Result handleBusinessException(BusinessException e) {
//        // 不打印异常堆栈信息
//        log.error(e.getMsg());
//        return Result.failure(e.getResultCode(),e.getMsg());
//    }
}
