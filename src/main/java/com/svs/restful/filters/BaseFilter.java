package com.svs.restful.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.svs.guice.ServiceInjector;

public abstract class BaseFilter implements Filter {

	public abstract boolean filterIncomingRequest(ServletRequest request,
			ServletResponse response) throws IOException, ServletException;

	public abstract void filterOutgoingResponse(ServletRequest request,
			ServletResponse response) throws IOException, ServletException;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ServiceInjector.getInjector().injectMembers(this);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if (this.filterIncomingRequest(request, response)) {
			chain.doFilter(request, response);
			this.filterOutgoingResponse(request, response);
		} else {
			return;
		}

	}

	@Override
	public void destroy() {

	}
}
