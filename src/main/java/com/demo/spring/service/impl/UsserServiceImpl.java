package com.demo.spring.service.impl;

import com.demo.spring.bean.User;
import com.demo.spring.constact.SexEnum;
import com.demo.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
    private RowMapper<User> getRowMapper() {
        RowMapper<User> userRowMapper = (ResultSet rs, int row) -> {
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
        String sql = "insert into t_user values(null, ? , ?, ?)";
        return this.jdbcTemplate.update(sql, user.getId(), user.getName(), user.getAge(), user.getSexEnum().getId());
    }

    @Override
    public int update(User user) {
        String sql = "update t_user set name=? , age=?, sex=?" + "where id=?";
        return this.jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getSexEnum().getId(), user.getId());
    }

    @Override
    public User selectUserById(Long uid) {
        Object params = new Object[]{uid};
        String sql = "select * from  t_user where id=?";
        return this.jdbcTemplate.queryForObject(sql, (Object[]) params, getRowMapper());
    }

    @Override
    public List<User> selectUserListByAgeOrName(User user) {
        Object params = new Object[]{user.getName(), user.getAge()};
        String sql = "select * from  t_user" + "where name like concat ('%',?,'%')" + "and age like concat('%',?,'%')";
        return jdbcTemplate.query(sql, (Object[]) params, getRowMapper());
    }

    @Override
    public int deleteById(Long uid) {
        Object params = new Object[]{uid};
        String sql = "select * from  t_user where id=?";
        return jdbcTemplate.update(sql, params);
    }

    /**
     * 实现StatementCallback 接口
     *
     * @param id
     * @return
     */
    public User getUser(Long id) {
        User result=this.jdbcTemplate.execute((Statement sta) -> {
            String sql = "select count(*) totalAmt from t_user where id= " + id;
            ResultSet resultSet = sta.executeQuery(sql);
            while (resultSet.next()) {
                int totalAmt = resultSet.getInt("totalAmt");
                System.out.println("totalAmt = " + totalAmt);
            }

            String sql2 = "select * total from t_user where id= " + id;
            ResultSet rst = sta.executeQuery(sql);
            User user=null;
            while (rst.next()) {
                int row = rst.getRow();
                user = getRowMapper().mapRow(rst, row);
            }
            return user;
        });
        return result;
    }

    /**
     * shixian   ConnectionCallback
     * @param id
     * @return
     */
    public User getUser3(Long id) {
        return this.jdbcTemplate.execute((Connection conn) -> {
            String sql = " select count(*) as total from t_user"
                    + " where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("total"));
            }
            String sql2 = " select id, user_name, sex, note from t_user "
                    + "where id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setLong(1, id);
            ResultSet rs2 = ps2.executeQuery();
            User user = null;
            while (rs2.next()) {
                user= getRowMapper().mapRow(rs2, rs2.getRow());
            }
            return user;
        });
    }



}
