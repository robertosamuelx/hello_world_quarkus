package org.acme;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class ExampleResource {
	
	@ConfigProperty(name="greeting.message")
	String message;
	
	@ConfigProperty(name = "greeting.suffix",defaultValue = "!")
	String suffix;
	
	@ConfigProperty(name = "greeting.name")
	Optional<String> name;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return message+ " " + name.orElse("world") + suffix;
    }
}