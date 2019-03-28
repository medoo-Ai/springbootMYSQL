package com.demo.spring.service;

import com.demo.spring.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther SyntacticSugar
 * @data 2019/3/29 0029上午 12:09
 */

public interface UserService {
    int insert(User user);
    int update(User user);
    User selectUserById(Long uid);
    List<User> selectUserListByAgeOrName(User user);
    int deleteById(Long uid);
}
