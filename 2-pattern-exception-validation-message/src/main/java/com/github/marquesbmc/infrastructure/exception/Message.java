package com.github.marquesbmc.infrastructure.exception;

import javax.ws.rs.core.Response.Status;

public class Message {
	private String exceptionUser;

	private String stackTrace;

	private String exceptions;

	private Status statusCode;

	public Message(String exU, String stT, String exp, Status st) {
		this.exceptionUser = exU;
		this.stackTrace = stT;
		this.exceptions = exp;
		this.statusCode = st;
	}

	public String getExceptionUser() {
		return exceptionUser;
	}

	public void setExceptionUser(String exceptionUser) {
		this.exceptionUser = exceptionUser;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public String getExceptions() {
		return exceptions;
	}

	public void setExceptions(String exceptions) {
		this.exceptions = exceptions;
	}

	public Status getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Status statusCode) {
		this.statusCode = statusCode;
	}

}
