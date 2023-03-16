package com.example.homework51.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Subscription {
    private String id;
    private User subscriber;
    private User subscription;
    private LocalDateTime eventDate;
}
