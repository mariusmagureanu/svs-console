package com.svs.restful.restricted;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;

import com.google.inject.Inject;
import com.svs.entities.User;
import com.svs.facade.interfaces.IUserFacade;

@Path("/user/")
public class UserResource extends BaseResource {

	@Inject
	private IUserFacade userFacade;

	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {

		final ArrayList<User> users = this.userFacade.getAll();
		try {
			final JSONArray jsonUsers = this.userFacade.toJSONArray(users);
			return Response.ok(jsonUsers.toString()).build();
		} catch (JSONException e) {
			return Response.serverError().build();
		}
	}

	@POST
	@Path("new")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(final String jsonUser) throws JSONException {
		final User user = this.userFacade.fromJSON(jsonUser);
		this.userFacade.save(user);
		return Response.ok().build();
	}

	@PUT
	public Response updateUser(String x) {
		return Response.ok(x.toString()).build();
	}
}
