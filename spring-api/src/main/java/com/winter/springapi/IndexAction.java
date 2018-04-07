package com.winter.springapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
public class IndexAction {
	
	@RequestMapping({"/","/spring-api1"})
	public JSONObject home() {
		
		JSONObject json = new JSONObject();
		json.put("hi", "spring-api");
		return json;
	}

}
