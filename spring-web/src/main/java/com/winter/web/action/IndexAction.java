package com.winter.web.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.winter.web.model.UserInfo;
import com.winter.web.service.IKafkaService;
import com.winter.web.service.IUserService;

@Controller
public class IndexAction {

	Logger log = LoggerFactory.getLogger(IndexAction.class);
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IKafkaService kafkaService;
	
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
	public ModelAndView index(Model model,HttpSession session) {
		model.addAttribute("name", "张三");
		return new ModelAndView("/index");
	}
	
	/**
	 * 发送信息到kafka
	 * @return
	 */
	@RequestMapping("/sendMessage")
	@ResponseBody
	public String sendMessage(String topic,String message) {
	
		String result = "success";
		try {
			kafkaService.sendMessage(topic, message);
		} catch (Exception e) {
			result = e.getMessage();
			e.printStackTrace();
		}
		
		return result;
	}

}
