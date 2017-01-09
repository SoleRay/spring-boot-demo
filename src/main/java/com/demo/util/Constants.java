package com.demo.util;

import com.demo.util.prop.PropUtil;

/**
 * 
 * ClassName: Constants 
 * @Description: 常量
 * @author likeke
 * @date 2016年5月12日
 * @version 1.0
 */
public class Constants {

	public static final String SESSION_KEY = "USER";

	public static final String SESSION_VALUE = "ADMIN";

	public static final String USER_NAME = PropUtil.getProperty("user.name");
	public static final String USER_PASSWORD = PropUtil.getProperty("user.password");

}
