package com.demo.exception;

import org.apache.log4j.Logger;

/**
 */
public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 5660370852963326274L;

	private static final Logger logger = Logger.getLogger(BusinessException.class);
	
	
	public BusinessException(String message) {
		super(message);
		logger.error(message);
	}
	
}
