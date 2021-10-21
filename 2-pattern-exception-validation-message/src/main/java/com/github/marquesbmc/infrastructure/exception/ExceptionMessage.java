package com.github.marquesbmc.infrastructure.exception;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.core.Response;

import com.github.marquesbmc.infrastructure.loader.PropertyFiles;



public class ExceptionMessage {

	public Message getClass(Throwable ex) throws IOException {

		ArrayList<Message> msgEx = new ArrayList<Message>();
		PropertyFiles propertyValue = new PropertyFiles();
		
		Message msg = new Message(null, null, null, null);  

		if ((ex instanceof javax.ws.rs.BadRequestException)) {
			msg.setExceptionUser(propertyValue.getPropValues("MSG.ERR001")); 		//<-- Alterar MSG
			msg.setExceptions(extractedException(ex)); 								//<-- Nao Alterar
			msg.setStackTrace(extractedStackTrace(ex)); 							//<-- Nao Alterar
			msg.setStatusCode(Response.Status.BAD_REQUEST);							//<-- Alterar Status
			msgEx.add(msg);
		
		} else if ((ex instanceof javax.ws.rs.NotAuthorizedException)) {
			msg.setExceptionUser(propertyValue.getPropValues("MSG.ERR002"));
			msg.setExceptions(extractedException(ex));
			msg.setStackTrace(extractedStackTrace(ex));
			msg.setStatusCode(Response.Status.UNAUTHORIZED); msgEx.add(msg);
			
		} else if ((ex instanceof javax.ws.rs.ForbiddenException)) {
			msg.setExceptionUser(propertyValue.getPropValues("MSG.ERR003"));
			msg.setExceptions(extractedException(ex));
			msg.setStackTrace(extractedStackTrace(ex));
			msg.setStatusCode(Response.Status.FORBIDDEN); msgEx.add(msg);
			
		} else if ((ex instanceof javax.ws.rs.NotFoundException	)) {
			msg.setExceptionUser(propertyValue.getPropValues("MSG.ERR004"));
			msg.setExceptions(extractedException(ex));
			msg.setStackTrace(extractedStackTrace(ex));
			msg.setStatusCode(Response.Status.NOT_FOUND); msgEx.add(msg);
		
		} else if ((ex instanceof javax.ws.rs.NotAllowedException)) {
			msg.setExceptionUser(propertyValue.getPropValues("MSG.ERR005"));
			msg.setExceptions(extractedException(ex));
			msg.setStackTrace(extractedStackTrace(ex));
			msg.setStatusCode(Response.Status.METHOD_NOT_ALLOWED); msgEx.add(msg);
		
		} else if ((ex instanceof javax.ws.rs.NotAcceptableException)) {
			msg.setExceptionUser(propertyValue.getPropValues("MSG.ERR006"));
			msg.setExceptions(extractedException(ex));
			msg.setStackTrace(extractedStackTrace(ex));
			msg.setStatusCode(Response.Status.NOT_ACCEPTABLE); msgEx.add(msg);
		
		} else if ((ex instanceof javax.ws.rs.NotSupportedException)) {
			msg.setExceptionUser(propertyValue.getPropValues("MSG.ERR007"));
			msg.setExceptions(extractedException(ex));
			msg.setStackTrace(extractedStackTrace(ex));
			msg.setStatusCode(Response.Status.UNSUPPORTED_MEDIA_TYPE); msgEx.add(msg);
		
		} else if ((ex instanceof javax.ws.rs.InternalServerErrorException)) {
			msg.setExceptionUser(propertyValue.getPropValues("MSG.ERR008"));
			msg.setExceptions(extractedException(ex));
			msg.setStackTrace(extractedStackTrace(ex));
			msg.setStatusCode(Response.Status.INTERNAL_SERVER_ERROR); msgEx.add(msg);

		} else if ((ex instanceof javax.ws.rs.ServerErrorException)) {
			msg.setExceptionUser(propertyValue.getPropValues("MSG.ERR008"));
			msg.setExceptions(extractedException(ex));
			msg.setStackTrace(extractedStackTrace(ex));
			msg.setStatusCode(Response.Status.SERVICE_UNAVAILABLE); msgEx.add(msg);
			
		} else if ((ex instanceof javax.ws.rs.ServiceUnavailableException)) {
			msg.setExceptionUser(propertyValue.getPropValues("MSG.ERR009"));
			msg.setExceptions(extractedException(ex));
			msg.setStackTrace(extractedStackTrace(ex));
			msg.setStatusCode(Response.Status.SERVICE_UNAVAILABLE); msgEx.add(msg);
		
		} else if ((ex instanceof javax.ws.rs.RedirectionException)) {
			msg.setExceptionUser(propertyValue.getPropValues("MSG.ERR010"));
			msg.setExceptions(extractedException(ex));
			msg.setStackTrace(extractedStackTrace(ex));
			msg.setStatusCode(Response.Status.MOVED_PERMANENTLY); msgEx.add(msg);
		
		} else if ((ex instanceof javax.ws.rs.ProcessingException)) {
			msg.setExceptionUser(propertyValue.getPropValues("MSG.ERR011"));
			msg.setExceptions(extractedException(ex));
			msg.setStackTrace(extractedStackTrace(ex));
			msg.setStatusCode(Response.Status.PRECONDITION_FAILED); msgEx.add(msg);
			
		//TODO : Continue inserindo excecoes e erros.
			
		} else {
			msg.setExceptionUser(propertyValue.getPropValues("MSG004"));
			msg.setExceptions(extractedException(ex));
			msg.setStackTrace(extractedStackTrace(ex));
			msg.setStatusCode(Response.Status.BAD_REQUEST);	
			msgEx.add(msg);
		}
		return msgEx.get(0);

	}

	private String extractedStackTrace(Throwable exception) {
		String violation = null;
		StackTraceElement elements[] = exception.getStackTrace();
		for (int i = 0, n = elements.length; i < n; i++) {
			violation += elements[i].getFileName() + ":" + elements[i].getLineNumber() + ">> "
					+ elements[i].getMethodName() + "()";
		}

		return violation;
	}

	private String extractedException(Throwable exception) {
		StringBuilder message = new StringBuilder(exception.getMessage());
		for (Throwable t = exception; t != null; t = t.getCause()) {
			message.append(", ").append(t.getMessage());
		}

		return message.toString();
	}



}
