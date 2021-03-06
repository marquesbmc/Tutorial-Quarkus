package com.github.marquesbmc.resource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.github.marquesbmc.model.Client;
import com.github.marquesbmc.service.ClientService;

@Path("/client/v1")
@Tag(name = "client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientResource {

	@Inject
	private ClientService clientService;

	@GET
	@Path("listall")
	@Operation(description = "Busca todos os clientes", summary = "Busca clientes cadastrados no sistema")
	public Response getAll() {
			
		return Response.ok().entity(clientService.listAll()).build();

	}
	
	
	@GET
	@Path("idsearch/{id}")
	public Response findId( @PathParam("id") Long id)   {
	
		return Response.ok().entity(clientService.findBy(id)).build();

	}
	

	@GET
	@Path("name/{name}")
	public Response getName2(@NotEmpty @NotBlank @PathParam("name") String name) {
		return Response.ok().entity(clientService.procurarNome(name)).build();
	}
	

	@POST
	@Transactional
	@Operation(description = "Cria novo cliente")
	// @APIResponse(responseCode = "201", description = "Caso o cliente esteja com
	// campo errado")
	// @APIResponse(responseCode = "400", content = @Content(schema = @Schema(allOf
	// = UnhandledExceptionMapper.class)))
	public Response create(Client client) {

		
	
		
		return Response.ok().entity(clientService.post(client)).build();
	}

	@PUT
	@Path("{id}")
	@Transactional
	public Response updateById(@Positive @PathParam("id") Long id, Client client) {
		return Response.ok(clientService.updateById(id, client), MediaType.APPLICATION_JSON).status(Response.Status.OK)
				.build();
	}

	@DELETE
	@Path("{id}")
	@Transactional
	public Response deleteById(@Positive @PathParam("id") Long id) {
		return Response.ok(clientService.deleteById(id), MediaType.APPLICATION_JSON).status(Response.Status.OK).build();
	}

}