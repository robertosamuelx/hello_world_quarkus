package org.acme;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.arc.config.ConfigProperties;

@Path("/properties")
@ConfigProperties(prefix = "greeting")
public class ExampleProperties {

	
	public String message;
	
	
	public String suffix="!";
	
	
	public Optional<String> name;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String response() {
		return message+ " " + name+suffix;
	}
	
	
}
