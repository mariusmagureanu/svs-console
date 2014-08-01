package com.svs.restful.restricted;

import javax.ws.rs.Path;

import com.google.inject.Inject;
import com.svs.entities.User;
import com.svs.facade.interfaces.IBaseFacade;
import com.svs.facade.interfaces.IUserFacade;

@Path("/user/")
public class UserResource extends BaseResource<User> {

	@Inject
	private IUserFacade userFacade;

	@Override
	protected IBaseFacade<User> getBaseFacade() {
		return this.userFacade;
	}
}
