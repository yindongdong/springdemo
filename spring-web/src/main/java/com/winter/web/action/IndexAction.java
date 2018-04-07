package com.winter.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.winter.web.model.UserInfo;
import com.winter.web.service.IUserService;

@Controller
public class IndexAction {

	@Autowired
	private IUserService userService;
	
	@RequestMapping({ "/", "/spring-web" })
	@ResponseBody
	public JSONObject home() {

		JSONObject json = new JSONObject();
		json.put("hi", userService.findById(3L));
		return json;
	}
	
	@RequestMapping({ "/updateUser/{id}"})
	@ResponseBody
	public String updateUser(@PathVariable Long id,String userName) {
		
		UserInfo userInfo = userService.findById(id);
		if (userInfo != null) {
			userInfo.setUserName(userName);
			UserInfo newUserInfo = userService.update(userInfo);
			
			return newUserInfo.toString();
		}
		return "userInfo is null!";
	}

	@RequestMapping("/index")
	public ModelAndView index(Model model) {
		
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		view.addObject("name", "张三");
		view.addObject("mobile", "13000000001");
		view.addObject("userAccount", "zhangsan");
		
		return view;
		
	}

}
