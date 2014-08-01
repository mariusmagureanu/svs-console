package com.svs.restful.restricted;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
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

import com.svs.entities.IBaseEntity;
import com.svs.facade.interfaces.IBaseFacade;
import com.svs.guice.ServiceInjector;

public abstract class BaseResource<T extends IBaseEntity> {

	protected abstract IBaseFacade<T> getBaseFacade();

	@PostConstruct
	public void init() {
		ServiceInjector.getInjector().injectMembers(this);
	}

	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {

		final ArrayList<T> entities = this.getBaseFacade().getAll();
		try {
			final JSONArray jsonEntities = this.getBaseFacade().toJSONArray(
					entities);
			return Response.ok(jsonEntities.toString()).build();
		} catch (JSONException e) {
			return Response.serverError().build();
		}
	}

	@POST
	@Path("new")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createEntity(final String jsonEntity) {

		try {
			final T entity = this.getBaseFacade().fromJSON(jsonEntity);
			this.getBaseFacade().save(entity);
			return Response.ok().build();

		} catch (JSONException e) {
			return Response.serverError().build();
		}
	}

	@PUT
	@Path("update")
	public Response updateEntity(String x) {
		return Response.ok(x.toString()).build();
	}
}
