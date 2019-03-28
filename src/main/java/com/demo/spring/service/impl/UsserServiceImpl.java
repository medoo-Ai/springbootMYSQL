package com.demo.spring.service.impl;

import com.demo.spring.bean.User;
import com.demo.spring.constact.SexEnum;
import com.demo.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

/**
 * @auther SyntacticSugar
 * @data 2019/3/29 0029上午 12:09
 */
@Service
public class UsserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 集jpa
    private RowMapper<User> getRowMapper(){
        RowMapper<User> userRowMapper=(ResultSet rs,int row)->{
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setAge(rs.getInt("age"));
            user.setName(rs.getString("name"));
            user.setSexEnum(SexEnum.getEnumById(rs.getInt("sex")));
            return user;
        };
        return userRowMapper;
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public User selectUserById(Long uid) {
        return null;
    }

    @Override
    public List<User> selectUserListByAgeOrName(User user) {
        return null;
    }

    @Override
    public int deleteById(Long uid) {
        return 0;
    }
}
