package com.winter.springzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.winter.springzuul.zuulfilters.AddResponseHeaderFilter;
import com.winter.springzuul.zuulfilters.PrefixRequestEntityFilter;
import com.winter.springzuul.zuulfilters.QueryParamPortPreFilter;
import com.winter.springzuul.zuulfilters.QueryParamServiceIdPreFilter;
import com.winter.springzuul.zuulfilters.UppercaseRequestEntityFilter;

@EnableZuulProxy
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class ZuulGatewayApplication extends SpringBootServletInitializer{
	
	@Bean
	public AddResponseHeaderFilter addResponseHeaderFilter() {
		return new AddResponseHeaderFilter();
	}

/*	@Bean
	public ModifyResponseBodyFilter modifyResponseHeaderFilter() {
		return new ModifyResponseBodyFilter();
	}*/

/*	@Bean
	public ModifyResponseDataStreamFilter modifyResponseDataStreamFilter() {
		return new ModifyResponseDataStreamFilter();
	}*/

	@Bean
	public PrefixRequestEntityFilter prefixRequestEntityFilter() {
		return new PrefixRequestEntityFilter();
	}

	@Bean
	public QueryParamPortPreFilter queryParamPortPreFilter() {
		return new QueryParamPortPreFilter();
	}

	@Bean
	public QueryParamServiceIdPreFilter queryParamServiceIdPreFilter() {
		return new QueryParamServiceIdPreFilter();
	}

	@Bean
	public UppercaseRequestEntityFilter modifyRequestEntityFilter() {
		return new UppercaseRequestEntityFilter();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ZuulGatewayApplication.class);
	}
	
}
