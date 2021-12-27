package com.github.marquesbmc.infrastructure.exception;

import static com.github.marquesbmc.infrastructure.enums.MsgErrors.ExceptionMapperHandled;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

import io.quarkus.arc.log.LoggerName;

@Provider
public class ExceptionMapperHandled implements ExceptionMapper<Exception> {

	@LoggerName("ExceptionMapperHandled")
	Logger logExceptionMapperHandled;
	

	@Override
	public Response toResponse(Exception ex) {
		
		

		PrepareMessage menssage = new PrepareMessage();
		try {

			return Response.status(menssage.getStatus(ex)).entity(menssage.getMessage(ex))
					.type(MediaType.APPLICATION_JSON).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity(ExceptionMapperHandled.toString())
					.type(MediaType.APPLICATION_JSON).build();
		} finally {

			logExceptionMapperHandled.warn(ex);
		}

	}

}
