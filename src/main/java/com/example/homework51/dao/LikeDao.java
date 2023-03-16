package com.example.homework51.dao;

import com.example.homework51.entity.Like;
import com.example.homework51.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LikeDao {
    private final JdbcTemplate jdbcTemplate;
        public List<Like> getLikes(){
            String sql = "select * from likes";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Like.class));

        }

    }
