package com.assignment.spring.exceptions;

public class ExceptionOpenweather extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final int code;
	
	public ExceptionOpenweather(String message, int code) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
