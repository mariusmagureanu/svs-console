package com.svs.guice;

import static com.google.inject.Scopes.SINGLETON;

import com.google.inject.AbstractModule;
import com.svs.facade.impl.CustomerFacade;
import com.svs.facade.impl.ItemFacade;
import com.svs.facade.impl.OrderFacade;
import com.svs.facade.impl.OrderLineFacade;
import com.svs.facade.impl.UserFacade;
import com.svs.facade.interfaces.ICustomerFacade;
import com.svs.facade.interfaces.IItemFacade;
import com.svs.facade.interfaces.IOrderFacade;
import com.svs.facade.interfaces.IOrderLineFacade;
import com.svs.facade.interfaces.IUserFacade;

public class ServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		 bind(IUserFacade.class).to(UserFacade.class).in(SINGLETON);
		 bind(ICustomerFacade.class).to(CustomerFacade.class).in(SINGLETON);
		 bind(IItemFacade.class).to(ItemFacade.class).in(SINGLETON);
		 bind(IOrderFacade.class).to(OrderFacade.class).in(SINGLETON);
		 bind(IOrderLineFacade.class).to(OrderLineFacade.class).in(SINGLETON);
	}
}
