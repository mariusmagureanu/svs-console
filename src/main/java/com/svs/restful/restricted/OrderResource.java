package com.svs.restful.restricted;

import javax.ws.rs.Path;

import com.google.inject.Inject;
import com.svs.entities.Orders;
import com.svs.facade.interfaces.IBaseFacade;
import com.svs.facade.interfaces.IOrderFacade;

@Path("/order/")
public final class OrderResource extends BaseResource<Orders>{
	
	@Inject
	private IOrderFacade orderFacade;

	@Override
	protected IBaseFacade<Orders> getBaseFacade() {
		return this.orderFacade;
	}

}
