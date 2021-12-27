package com.github.marquesbmc.infrastructure.exception;

import java.util.ArrayList;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ExceptionMessage {

	public Message getClass(Exception ex) {

		ArrayList<Message> msgEx = new ArrayList<Message>();

		Message msg = new Message(null, null, null);

		msg.setExceptions(extractedException(ex));
		msg.setStackTrace(extractedStackTrace(ex));
		msg.setStatusCode(getStatusCode(ex));
		msgEx.add(msg);
		return msgEx.get(0);

	}

	private String extractedStackTrace(Exception exception) {
		String violation = null;
		StackTraceElement elements[] = exception.getStackTrace();
		for (int i = 0, n = elements.length; i < n; i++) {
			violation += elements[i].getFileName() + ":" + elements[i].getLineNumber() + ">> "
					+ elements[i].getMethodName() + "()";
		}

		return violation;
	}

	private String extractedException(Exception exception) {
		StringBuilder message = new StringBuilder(exception.getMessage());
		for (Throwable t = exception; t != null; t = t.getCause()) {
			message.append(", ").append(t.getMessage());
		}

		return message.toString();
	}

	private Status getStatusCode(Exception exception) {

		Status statusCode = null;

		if ((exception instanceof javax.ws.rs.NotAuthorizedException)) {
			statusCode = Status.UNAUTHORIZED;
		} else if ((exception instanceof javax.ws.rs.ForbiddenException)) {
			statusCode = Status.FORBIDDEN;
		} else if ((exception instanceof javax.ws.rs.NotFoundException)) {
			statusCode = Status.NOT_FOUND;
		} else if ((exception instanceof javax.ws.rs.NotAllowedException)) {
			statusCode = Status.METHOD_NOT_ALLOWED;
		} else if ((exception instanceof javax.ws.rs.NotAcceptableException)) {
			statusCode = Status.NOT_ACCEPTABLE;
		} else if ((exception instanceof javax.ws.rs.NotSupportedException)) {
			statusCode = Status.UNSUPPORTED_MEDIA_TYPE;
		} else if ((exception instanceof javax.ws.rs.InternalServerErrorException)) {
			statusCode = Status.INTERNAL_SERVER_ERROR;
		} else if ((exception instanceof javax.ws.rs.ServerErrorException)) {
			statusCode = Status.SERVICE_UNAVAILABLE;
		} else if ((exception instanceof javax.ws.rs.RedirectionException)) {
			statusCode = Status.MOVED_PERMANENTLY;
		} else if ((exception instanceof javax.ws.rs.ProcessingException)) {
			statusCode = Status.PRECONDITION_FAILED;

			// ... new exceptions/status code....

		} else {
			statusCode = Status.BAD_REQUEST;
		}

		return statusCode;

	}

}
