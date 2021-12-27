package com.github.marquesbmc.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.github.marquesbmc.model.storeprocedures.DadosNotaEmpenhoOGUSP017;
import com.github.marquesbmc.repository.OGUSP017Repository;

@Path("/hello")
public class GreetingResource {

	@Inject
	OGUSP017Repository OGUSP017Repository;

	@GET
	@Path("/teste")
	public Response listaTeste(@QueryParam("num") Long num) {
		List<DadosNotaEmpenhoOGUSP017> lista = OGUSP017Repository.getListaTeste(num);
		return Response.ok(lista).build();
	}

}