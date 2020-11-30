package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.domains.UserDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("/users")
    public Map<String, String> join(@RequestBody UserDto user){
        System.out.println("============= Join ==========");
        Map<String, String> map = new HashMap<>();
        System.out.println("아이디: "+user.getUserid());
        System.out.println("비번: "+user.getPassword());
        System.out.println("이름: "+user.getName());
        return map;
        
    }
}
