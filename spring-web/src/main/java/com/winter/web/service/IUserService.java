package com.winter.web.service;

import com.winter.web.model.UserInfo;

public interface IUserService {

	public String play(String name);

	/**
	 * 通过ID获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	public UserInfo findById(long id);

	/**
	 * 更新用户信息
	 * 
	 * @param userInfo
	 * @return
	 */
	public UserInfo update(UserInfo userInfo);

}
