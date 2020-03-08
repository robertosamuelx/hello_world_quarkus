package org.acme;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

import io.vertx.core.http.HttpServerRequest;

@Provider
public class LogginFilter implements ContainerRequestFilter{

	private static final Logger log = Logger.getLogger(LogginFilter.class);
	
	@Context
	UriInfo info;
	
	@Context
	HttpServerRequest request;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		final String method = requestContext.getMethod();
		
		final String path = info.getPath();
		
		final String address = request.remoteAddress().toString();
		
		log.infof("Request %s %s from IP %s",method,path,address);
	}
	
	
}
