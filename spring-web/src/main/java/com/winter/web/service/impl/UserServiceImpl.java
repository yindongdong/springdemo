package com.winter.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.web.dao.UserRepository;
import com.winter.web.model.UserInfo;
import com.winter.web.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String play(String name) {
		return name + " play!";
	}

	@Override
	public UserInfo findById(long id) {
		if (id <= 0) {
			return null;
		}
		UserInfo userInfo = userRepository.findOne(id);
		return userInfo;
	}

	@Override
	public UserInfo update(UserInfo userInfo) {
		return userRepository.save(userInfo);
	}

}
