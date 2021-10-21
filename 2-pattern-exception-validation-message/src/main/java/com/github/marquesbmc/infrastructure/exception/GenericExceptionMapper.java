package com.github.marquesbmc.infrastructure.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {

		PrepareMessage msg = new PrepareMessage();
		try {
			return Response
					.status(msg.getStatus(exception))
					.entity(msg.getMessage(exception))
					.type(MediaType.APPLICATION_JSON)
					.build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response
					.status(500)
					.entity("Erro:Mensagem n\\u00e3o tratada.")
					.build();
		}

	}

}
