package com.example.homework51.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Like {
    private String id;
    private User whoLikes;
    private Publication publication;
    private LocalDateTime likeDate;
}
