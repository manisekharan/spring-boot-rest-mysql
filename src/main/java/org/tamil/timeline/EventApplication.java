package org.tamil.timeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan
public class EventApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(EventApplication.class);

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(EventApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\n----Begin logging EventApplication----");

		logger.info("----System Properties from VM Arguments----");
		logger.info("server.port: " + System.getProperty("server.port"));
		logger.info("----Program Arguments----");
		for (String arg : args) {
			logger.info(arg);
		}

		if (environment != null) {
			getActiveProfiles();
			logger.info("----Environment Properties----");
			logger.info("server.port: " + environment.getProperty("server.port"));
			logger.info("org.tamil.timeline.environment: " + environment.getProperty("nl.amis.environment"));
			logger.info("spring.datasource.url: " + environment.getProperty("spring.datasource.url"));
			logger.info("spring.h2.console.enabled: " + environment.getProperty("spring.h2.console.enabled"));
			logger.info("spring.jpa.hibernate.ddl-auto: " + environment.getProperty("spring.jpa.hibernate.ddl-auto"));
		}
		logger.info("----End logging EventApplication----");
	}

	private void getActiveProfiles() {
		for (final String profileName : environment.getActiveProfiles()) {
			logger.info("Currently active profile - " + profileName);
		}
	}
}
