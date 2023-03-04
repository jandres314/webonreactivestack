package com.demo.reactive.presentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class Routing {
	
	@Bean
	RouterFunction<ServerResponse> root(PersonHandler handler) {
		return RouterFunctions.route()
		  .GET("/person/max-age", RequestPredicates.accept(MediaType.APPLICATION_JSON), handler::maxAge)
		  .GET("/person", RequestPredicates.accept(MediaType.APPLICATION_JSON), handler::listPeople)		  
		  .build();
	}

}
