package com.winter.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:spring-beetl.xml")
@EnableDiscoveryClient
@SpringBootApplication
public class SpringWebApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringWebApplication.class);
	}

}
