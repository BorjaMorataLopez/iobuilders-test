package org.acme.iobuilders.infraestructure.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.acme.iobuilders.application.api.dto.UserDto;
import org.acme.iobuilders.application.service.BankApiService;
import org.jboss.resteasy.annotations.GZIP;

@Path("/user")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class BankApi {


	@Inject
	BankApiService service;
    
	@GET
	@Path("/{id}")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@GZIP
	public Response getUser(@PathParam("id") String id) {
		return Response.ok().entity(service.getUser(id)).build();
	}
	
    @POST
	@Path("/")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@GZIP
	public Response createUser(UserDto user) {
		service.createUser(user);
		return Response.ok().entity(user).build();
	}
    
    @PATCH
	@Path("/{id}/add/{amount}")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@GZIP
	public Response addMoney(@PathParam("id") String id, @PathParam("amount") double amount) {
    	service.addMoney(id, amount);
		return Response.ok().build();
	}
    
    @PATCH
	@Path("/origin/{idOrigin}/destination/{idDestination}/amount/{amount}")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@GZIP
	public Response transfer(@PathParam("idOrigin") String idOrigin, @PathParam("idDestination") String idDestination,
			@PathParam("amount") double amount) {
    	service.transfer(idOrigin, idDestination, amount);
		return Response.ok().build();
	}
}