package com.svs.restful.restricted;

import javax.ws.rs.Path;

import com.google.inject.Inject;
import com.svs.entities.Customer;
import com.svs.facade.interfaces.IBaseFacade;
import com.svs.facade.interfaces.ICustomerFacade;


@Path("/customer/")
public final class CustomerResource extends BaseResource<Customer> {
	
	@Inject
	private ICustomerFacade customerFacade;

	@Override
	protected IBaseFacade<Customer> getBaseFacade() {
		return this.customerFacade;
	}
}
