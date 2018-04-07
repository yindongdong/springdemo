package com.winter.springcore;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
public class IndexAction {
	
	@RequestMapping({"/","/spring-core1"})
	public JSONObject home() {
		
		JSONObject json = new JSONObject();
		json.put("hi", "spring-core");
		return json;
	}

}
