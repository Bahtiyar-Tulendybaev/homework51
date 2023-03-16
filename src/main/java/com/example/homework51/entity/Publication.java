package com.example.homework51.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Publication {
    private User user;
    private String picture;
    private String description;
    private LocalDateTime publicDate;
}
