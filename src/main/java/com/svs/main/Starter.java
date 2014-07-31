package com.svs.main;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public final class Starter {

	private static final int DEFAULT_HTTP_PORT = 8080;
	private static final String DEFAULT_HTTP_HOST = "0.0.0.0";
	private static Server server = new Server();

	
	public static void main(String[] args) throws Exception {

		final Connector connector = new SelectChannelConnector();
		connector.setHost(DEFAULT_HTTP_HOST);
		connector.setPort(DEFAULT_HTTP_PORT);

		final WebAppContext webapp = new WebAppContext();
		webapp.setParentLoaderPriority(true);
		webapp.setContextPath("/");
		webapp.setServer(server);
		String workingDirectory = System.getProperty("user.dir");
		System.out.print(workingDirectory);
//	    webapp.setWar("/Users/mariusmagureanu/workspace/svs-console/svs-console.war");
	    webapp.setWar(workingDirectory+"/svs-console.war");

	    
	    server.setHandler(webapp);
		server.addConnector(connector);

		server.start();
		server.setStopAtShutdown(true);
	}
}
