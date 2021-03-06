package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.jboss.logging.Logger;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class AppLifecycleBean {

	private static final Logger LOGGER = Logger.getLogger("ListenerBean");
	
	public void OnStart(@Observes StartupEvent ev) {
		LOGGER.info("This application is starting...");
	}
	
	public void onStop(@Observes ShutdownEvent ev) {
		LOGGER.info("This application is stopping...");
	}
}
