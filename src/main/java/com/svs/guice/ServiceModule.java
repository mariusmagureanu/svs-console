package com.svs.guice;

import static com.google.inject.Scopes.SINGLETON;

import com.google.inject.AbstractModule;
import com.svs.facade.impl.UserFacade;
import com.svs.facade.interfaces.IUserFacade;

public class ServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		 bind(IUserFacade.class).to(UserFacade.class).in(SINGLETON);
		
	}
}
