package com.svs.restful.restricted;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("/customer/")
public class CustomerResource extends BaseResource {
	
	@GET
	@Path("list")
	public Response getCustomer(){
		return Response.ok("gg\n").build();
	}
}
