package com.winter.springzuul.zuulfilters;

import org.springframework.context.annotation.Bean;

public class ZuulGatewayApplication {

	@Bean
	public AddResponseHeaderFilter addResponseHeaderFilter() {
		return new AddResponseHeaderFilter();
	}

	@Bean
	public ModifyResponseBodyFilter modifyResponseHeaderFilter() {
		return new ModifyResponseBodyFilter();
	}

	@Bean
	public ModifyResponseDataStreamFilter modifyResponseDataStreamFilter() {
		return new ModifyResponseDataStreamFilter();
	}

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

}
