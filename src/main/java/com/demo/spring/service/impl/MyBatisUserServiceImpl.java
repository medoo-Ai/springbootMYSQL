package com.demo.spring.service.impl;

import com.demo.spring.dao.MyBatisUserDao;
import com.demo.spring.pojo.User;
import com.demo.spring.service.MyBatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**** imports ****/
@Service
public class MyBatisUserServiceImpl implements MyBatisUserService {
    @Autowired
    private MyBatisUserDao myBatisUserDao = null;
    
    @Override
    public User getUser(Long id) {
        return myBatisUserDao.getUser(id);
    }
}