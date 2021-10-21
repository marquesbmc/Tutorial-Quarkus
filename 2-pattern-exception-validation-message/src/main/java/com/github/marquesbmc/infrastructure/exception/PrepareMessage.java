package com.github.marquesbmc.infrastructure.exception;

import javax.ws.rs.core.Response.Status;

public class PrepareMessage {

	private Message msgException;
	private ExceptionMessage exMsg = new ExceptionMessage();

	public String getMessage(Throwable ex) throws Exception {

		msgException = exMsg.getClass(ex);
		
		return "{\"mensagem_usuario\":" + "\"" + 
				msgException.getExceptionUser() + "\"," +
				"\"mensagem_desenvolvedor\":[{" + "\"violacões\":" + "\"" + 
				msgException.getExceptions() + "\"," +
				"\"stacktrace\":" + "\"" +
				msgException.getStackTrace() + "\"" + "]}}";

	}

	public Status getStatus(Throwable ex) throws Exception {
		
		msgException = exMsg.getClass(ex);

		Status statusCode = msgException.getStatusCode();

		return statusCode;
	}

}
