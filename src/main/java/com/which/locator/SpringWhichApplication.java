package com.which.locator;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringWhichApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringWhichApplication.class, args);
		BasicConfigurator.configure();

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringWhichApplication.class);
	}

}
