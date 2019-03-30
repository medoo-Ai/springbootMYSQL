package com.demo.spring.service;
import com.springboot.chapter5.pojo.User;
public interface MyBatisUserService {
    public User getUser(Long id);
}