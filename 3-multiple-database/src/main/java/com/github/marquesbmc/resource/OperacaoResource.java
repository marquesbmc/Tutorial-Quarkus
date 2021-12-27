package com.github.marquesbmc.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.marquesbmc.service.OperacaoService;

@Path("/listar")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OperacaoResource {


	@Inject
	OperacaoService operacaoService;

	@GET
	public Response listaUf() {
		return Response.ok(operacaoService.listaUf()).build();
	}



}
