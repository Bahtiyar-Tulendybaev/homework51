package com.example.homework51.dao;

import com.example.homework51.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UsersDao {
    private final JdbcTemplate jdbcTemplate;

    public List<User> getUsers(){
        String sql = "select * from users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

    }
    public List<User>userGetName(){
        String sql = "select * from users where name = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
}
