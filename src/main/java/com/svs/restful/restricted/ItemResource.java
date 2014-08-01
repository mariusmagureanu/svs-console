package com.svs.restful.restricted;

import javax.ws.rs.Path;

import com.google.inject.Inject;
import com.svs.entities.Item;
import com.svs.facade.interfaces.IBaseFacade;
import com.svs.facade.interfaces.IItemFacade;

@Path("/item/")
public final class ItemResource extends BaseResource<Item> {
	
	@Inject
	private IItemFacade itemFacade;
	
	@Override
	protected IBaseFacade<Item> getBaseFacade() {
		return this.itemFacade;
	}

}
