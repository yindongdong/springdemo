package com.winter.springapi;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@Configuration
@EnableAutoConfiguration
public class IndexAction {

	String name = "";

	@RequestMapping({ "/", "/spring-api1" })
	public JSONObject home() {

		JSONObject json = new JSONObject();
		json.put("hi", "spring-api:"+name);
		return json;
	}

}
