package com.demo.spring.service.impl;

import com.demo.spring.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @auther SyntacticSugar
 * @data 2019/3/30 0030下午 12:06
 */
public class CallBackIMPL {

    @Autowired
    private JdbcTemplate jdbcTemplate;


}
