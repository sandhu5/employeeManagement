package com.springmvc.controller;

public class EmployeeException extends RuntimeException {

	//private static final long serialVersionUID = -4794572499177930357L;

	private static final long serialVersionUID = -70348971907466939L;
	private String exceptionMsg;

	public EmployeeException(String exceptionMsg) {
		super();
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionMsg() {
		return this.exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
}