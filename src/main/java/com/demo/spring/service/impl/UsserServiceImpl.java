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

    // 集
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
        String sql="insert into t_user values(null, ? , ?, ?)";
        return this.jdbcTemplate.update(sql, user.getId(),user.getName(),user.getAge(),user.getSexEnum().getId());
    }

    @Override
    public int update(User user) {
        String sql="update t_user set name=? , age=?, sex=?"+"where id=?";
        return this.jdbcTemplate.update(sql, user.getName(),user.getAge(),user.getSexEnum().getId(),user.getId());
    }

    @Override
    public User selectUserById(Long uid) {
        Object params=new Object[]{uid};
        String sql="select * from  t_user where id=?";
        return this.jdbcTemplate.queryForObject(sql, (Object[]) params,getRowMapper());
    }

    @Override
    public List<User> selectUserListByAgeOrName(User user) {
        Object params=new Object[]{user.getName(),user.getAge()};
        String sql="select * from  t_user"+"where name like concat ('%',?,'%')"+"and age like concat('%',?,'%')";
        return jdbcTemplate.query(sql, (Object[]) params,getRowMapper());
    }

    @Override
    public int deleteById(Long uid) {
        Object params=new Object[]{uid};
        String sql="select * from  t_user where id=?";
        return jdbcTemplate.update(sql, params);
    }
}
