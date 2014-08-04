package com.svs.restful.filters;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;
import com.svs.facade.interfaces.IUserFacade;

public final class SecurityFilter extends BaseFilter {

	@Inject
	private IUserFacade userFacade;

	@Override
	public boolean filterIncomingRequest(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {

		final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		final HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		final String userName = httpServletRequest.getHeader("username");
		final String password = httpServletRequest.getHeader("password");

		if (userName == null || password == null) {
			httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
			return false;
		} else {
			if (!this.userFacade.isValidUser(userName, password)) {
				httpServletResponse
						.sendError(HttpServletResponse.SC_UNAUTHORIZED);
				return false;
			}
		}

		return true;
	}

	@Override
	public void filterOutgoingResponse(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {

	}

}
