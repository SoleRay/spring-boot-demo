package com.demo.exception;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 */
public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 5660370852963326274L;

	private static Logger logger = LogManager.getLogger(BusinessException.class);
	
	
	public BusinessException(String message) {
		super(message);
		logger.error(message);
	}
	
}
