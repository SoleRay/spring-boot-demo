package com.demo.util.resp;


import com.demo.bean.result.Result;
import com.demo.enums.resp.RespStatusEnum;

public class ResponseUtil {


	/**
	 * 请求成功——无返回数据
	 */
	public static Result setDefaultSuccessResponse() {
		return new Result(RespStatusEnum.SUCCESS.getCode(), RespStatusEnum.SUCCESS.getMsg());
	}

	/**
	 * 请求成功——有返回数据
	 */
	public static Result setSuccessDataResponse(Object data) {
		return new Result(RespStatusEnum.SUCCESS.getCode(),RespStatusEnum.SUCCESS.getMsg(), data);
	}

	/**
	 * 请求失败——出现系统级错误，非业务类异常
	 */
	public static Result setSysErrorResponse() {
		return new Result(RespStatusEnum.SYS_ERROR.getCode(), RespStatusEnum.SYS_ERROR.getMsg());
	}

	/**
	 * 请求失败——业务类错误，返回提示消息，code默认
	 */
	public static Result setBusErrorResponse(String msg) {
		Result result = new Result(RespStatusEnum.BUS_ERROR.getCode(), msg);
		return result;
	}

	/**
	 * 请求失败——业务类错误，返回提示消息，code自定义，用于不同code进行不同的跳转
	 */
	public static Result setBusErrorResponse(int code,String msg) {
		Result result = new Result(code, msg);
		return result;
	}
}
