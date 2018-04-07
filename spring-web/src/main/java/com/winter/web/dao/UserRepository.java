package com.winter.web.dao;

import org.springframework.data.repository.CrudRepository;

import com.winter.web.model.UserInfo;

public interface UserRepository extends CrudRepository<UserInfo, Long>{

}
