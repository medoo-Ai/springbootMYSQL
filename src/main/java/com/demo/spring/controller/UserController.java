package com.demo.spring.controller;

import com.demo.spring.bean.User;
import com.demo.spring.jpa.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @auther SyntacticSugar
 * @data 2019/3/30 0030下午 1:00
 */
@RestController("user")
public class UserController {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @GetMapping("getUserById")
    public User getUser(Long id) {
        return userJpaRepository.findById(id).get();
    }

}
