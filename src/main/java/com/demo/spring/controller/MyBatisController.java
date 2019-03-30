package com.demo.spring.controller;

import com.demo.spring.pojo.User;
import com.demo.spring.service.MyBatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**** imports ****/
@Controller
@RequestMapping("/mybatis")
public class MyBatisController {
	
	@Autowired
	private MyBatisUserService myBatisUserService = null;
	
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser(Long id) {
		return myBatisUserService.getUser(id);
	}
}