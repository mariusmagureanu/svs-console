package com.svs.restful.restricted;

import javax.annotation.PostConstruct;

import com.svs.guice.ServiceInjector;

public abstract class BaseResource {

	@PostConstruct
	public void init() {
		ServiceInjector.getInjector().injectMembers(this);
	}
}
