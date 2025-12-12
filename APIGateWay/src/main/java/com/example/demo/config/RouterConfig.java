package com.example.demo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfig {

	@Bean
	public RouteLocator createRoutes(RouteLocatorBuilder builder )
	{
		return builder.routes()
				.route("Service1", r->r.path("/user/**")
				.uri("lb://Service1"))
				.route("Service2", r->r.path("/admin/**")
						.uri("lb://Service2"))
				.build();
				
	}
}
