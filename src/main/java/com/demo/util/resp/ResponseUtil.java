package com.demo.util.resp;


import com.demo.bean.result.Result;
import com.demo.enums.resp.ResponseStatus;

public class ResponseUtil {

	/**
	 * 返回错误码和错误提示
	 */
	public static Result setErrResponse(ResponseStatus status) {
		Result result = new Result(status.getCode(), status.getMsg());
		return result;
	}

	/**
	 * 返回错误码和错误提示
	 */
	public static Result setErrResponse(String msg) {
		Result result = new Result(ResponseStatus.NORMAL_ERROR.getCode(), msg);
		return result;
	}
	
	/**
	 * 成功处理了请求
	 */
	public static Result setDefaultErrResponse() {
		return new Result(ResponseStatus.SYS_ERROR.getCode(), ResponseStatus.SYS_ERROR.getMsg());
	}
	/**
	 * 成功处理了请求
	 */
	public static Result setDefaultSuccessResponse() {
		return new Result(ResponseStatus.OK.getCode(), ResponseStatus.OK.getMsg());
	}

	/**
	 * 成功请求后返回数据
	 * @param data
	 */
	public static Result setSuccessDataResponse(Object data) {
		return new Result(ResponseStatus.OK.getCode(),ResponseStatus.OK.getMsg(), data);
	}

}
