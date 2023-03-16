package com.example.homework51.controller;

import com.example.homework51.Hw51Service;
import com.example.homework51.entity.Comment;
import com.example.homework51.entity.Like;
import com.example.homework51.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class Hw51Controller {
    private final Hw51Service service;

    @GetMapping("/connect")
    public ResponseEntity<String> connection(){
        return new ResponseEntity<>(service.connect(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String>create(){
        return new ResponseEntity<>(service.shouldCreateTable(), HttpStatus.OK);
    }
    @PostMapping("/create/comments")
    public ResponseEntity<String>createComment(){
        return new ResponseEntity<>(service.shouldCreateCommentTable(), HttpStatus.OK);
    }
    @GetMapping("/select")
    public ResponseEntity<String> select(){
        return new ResponseEntity<>(service.shouldSelectData(),HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getCustomers(){
        return new ResponseEntity<>(service.getUsers(),HttpStatus.OK);
    }
    @GetMapping("/users/name")
    public ResponseEntity<List<User>> getUserName(){
        return new ResponseEntity<>(service.userGetName(),HttpStatus.OK);
    }
    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getComments(){
        return new ResponseEntity<>(service.getComments(),HttpStatus.OK);
    }
    @PostMapping("/createLike")
    public ResponseEntity<String>createLike(){
        return new ResponseEntity<>(service.shouldCreateLikeTable(), HttpStatus.OK);
    }
    @GetMapping("/likes")
     public ResponseEntity<List<Like>>getLike(){
        return new ResponseEntity<>(service.getLikes(), HttpStatus.OK);
    }
}
