package com.svs.restful.restricted;

import javax.ws.rs.Path;

import com.google.inject.Inject;
import com.svs.entities.OrderLine;
import com.svs.facade.interfaces.IBaseFacade;
import com.svs.facade.interfaces.IOrderLineFacade;

@Path("/orderline/")
public final class OrderLineResource extends BaseResource<OrderLine> {

	@Inject
	private IOrderLineFacade orderLineFacade;
	
	@Override
	protected IBaseFacade<OrderLine> getBaseFacade() {
		return this.orderLineFacade;
	}

}
