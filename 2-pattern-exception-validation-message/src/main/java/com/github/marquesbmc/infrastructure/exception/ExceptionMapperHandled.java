package com.github.marquesbmc.infrastructure.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import io.quarkus.arc.log.LoggerName;
import org.jboss.logging.Logger;

@Provider
public class ExceptionMapperHandled implements ExceptionMapper<Exception> {

	@LoggerName("ExceptionMapperHandled")
	Logger LogExceptionMapperHandled;

	@Override
	public Response toResponse(Exception ex) {

		PrepareMessage menssage = new PrepareMessage();
		try {

			return Response.status(menssage.getStatus(ex)).entity(menssage.getMessage(ex))
					.type(MediaType.APPLICATION_JSON).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Erro:Mensagem n\\u00e3o tratada, favor tentar novamente!")
					.type(MediaType.APPLICATION_JSON).build();
		} finally {

			LogExceptionMapperHandled.warn(ex);
		}

	}

}
