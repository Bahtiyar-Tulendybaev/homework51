package com.example.homework51.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String login;
    private String name;
    private String email;
    private String password;
    private Integer publicationsCount;
    private Integer subscriptionsCount;
    private Integer subscribersCount;
}
