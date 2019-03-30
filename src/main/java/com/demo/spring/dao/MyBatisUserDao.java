package com.demo.spring.dao;

import com.demo.spring.pojo.User;
import org.springframework.stereotype.Repository;


/**** imports ****/
@Repository
public interface MyBatisUserDao {
	public User getUser(Long id);
}