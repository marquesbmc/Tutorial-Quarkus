package com.github.marquesbmc.infrastructure.exception;

import javax.ws.rs.core.Response.Status;

public class Message {

	private String stackTrace;

	private String exceptions;

	private Status statusCode;

	public Message(String stT, String exp, Status st) {

		this.stackTrace = stT;
		this.exceptions = exp;
		this.statusCode = st;
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
