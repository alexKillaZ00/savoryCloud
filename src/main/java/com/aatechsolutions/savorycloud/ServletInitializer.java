package com.aatechsolutions.savorycloud;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	//hola soy armando
	//hola soy alexis
	//hola este es mi segundo cambio
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SavorycloudApplication.class);
	}

}
