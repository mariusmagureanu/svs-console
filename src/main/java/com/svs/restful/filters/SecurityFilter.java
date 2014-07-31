package com.svs.restful.filters;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public final class SecurityFilter extends BaseFilter {

	
	@Override
	public boolean filterIncomingRequest(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
		return true;
	}

	@Override
	public void filterOutgoingResponse(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
	
		
	}

}
