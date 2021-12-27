package com.github.marquesbmc.resource;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.github.marquesbmc.model.Client;
import com.github.marquesbmc.service.ClientService;

@Path("/client/v1")
@Tag(name = "client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientResource  {
	
	private static final Logger LOG = Logger.getLogger(ClientResource.class);

	@ConfigProperty(name = "knowledgefactory.custom.error.msg.badrequest.JsonbException")
	String jsonbException;

	@ConfigProperty(name = "knowledgefactory.custom.error.msg.processingException")
	String processingException;

	@Inject
	private ClientService clientService;

	
	@GET
	@Path("listall")
	@Operation(description = "Busca todos os clientes", summary = "Busca clientes cadastrados no sistema")
	public Response getAll() throws Exception{
	
			return Response.ok(clientService.listAll(), MediaType.APPLICATION_JSON).status(Response.Status.OK).build();
	}

	@GET
	@Path("idsearch/{id}")
	public Response findId(@Positive @NotNull @PathParam("id") Long id) throws Exception {
		return Response.ok(clientService.findBy(id), MediaType.APPLICATION_JSON).status(Response.Status.OK).build();
	}

	@GET
	@Path("name/{name}")
	public Response getName2(@NotEmpty @NotBlank @PathParam("name") String name) throws Exception {
		return Response.ok(clientService.procurarNome(name), MediaType.APPLICATION_JSON).status(Response.Status.OK)
				.build();
	}

	@POST
	@Transactional
	@Operation(description = "Cria novo cliente")
	@Path("cria_client")
	// @APIResponse(responseCode = "201", description = "Caso o cliente esteja com
	// campo errado")
	// @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf
	// = UnhandledExceptionMapper.class)))
	public Response create(Client client)  throws Exception{

		return Response.ok(clientService.post(client), MediaType.APPLICATION_JSON).status(Response.Status.CREATED)
				.build();
	}
	
	
	@POST
	@Transactional
	@Operation(description = "div zero")
	@Path("div_zero")
	public Response divZero(Long z)  throws Exception{

		return Response.ok(clientService.divZero(z), MediaType.APPLICATION_JSON)
				.build();
	}
	
	
	

	@PUT
	@Path("{id}")
	@Transactional
	public Response updateById(@Positive @PathParam("id") Long id, Client client) throws Exception {
		return Response.ok(clientService.updateById(id, client), MediaType.APPLICATION_JSON).status(Response.Status.OK)
				.build();
	}

	@DELETE
	@Path("{id}")
	@Transactional
	public Response deleteById(@Positive @PathParam("id") Long id) throws Exception {
		return Response.ok(clientService.deleteById(id), MediaType.APPLICATION_JSON).status(Response.Status.OK).build();
	}

}