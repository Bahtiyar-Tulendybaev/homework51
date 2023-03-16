package com.example.homework51.dao;

import com.example.homework51.entity.Comment;
import com.example.homework51.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CommentDao {
    private final JdbcTemplate jdbcTemplate;
    public List<Comment>getComments(){
        String sql = "select * from comments";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Comment.class));

    }
}
