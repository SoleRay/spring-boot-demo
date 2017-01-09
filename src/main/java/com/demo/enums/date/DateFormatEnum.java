package com.demo.enums.date;

/**
 */
public enum DateFormatEnum {

	yyyy_MM_dd("yyyy-MM-dd"),
	yyyy_MM("yyyy-MM"),
	yyyy_MM_dd0HH$mm$ss("yyyy-MM-dd HH:mm:ss"),
	yyyyMMdd("yyyyMMdd"),
	yyyyMMddHHmmss("yyyyMMddHHmmss");
	
    private String value;

	private DateFormatEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
