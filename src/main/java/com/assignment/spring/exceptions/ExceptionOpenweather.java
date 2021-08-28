package com.assignment.spring.exceptions;

public class ExceptionOpenweather extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ExceptionOpenweather() {
		super();
	}
	
	public ExceptionOpenweather(String message) {
		super(message);
	}

}
