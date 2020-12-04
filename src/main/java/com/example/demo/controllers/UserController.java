package com.example.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.domains.UserDto;
import com.example.demo.services.UserService;
import com.example.demo.utils.Printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{
    @Autowired UserService userService;
    @Autowired Printer printer;
   
    @PostMapping("/users")
    public Map<?, ?> join(@RequestBody UserDto user){
        printer.accept("======= join 에 들어옴 =======");
        
        var map = new HashMap<>();
       
        int result = userService.join(user);
        if(result == 1){
            map.put("message","SUCCESS");
        }
        return map;
    }
    @PostMapping("/users/login")
    public Map<?, ?> login(@RequestBody UserDto user){
        printer.accept("======= login 에 들어옴 =======");
        var map = new HashMap<>();
        UserDto result = userService.login(user);
        if(result != null){
            map.put("message", "SUCCESS");
            map.put("loginUser",result);
            
        }else{
            map.put("message","FAILURE");
            map.put("loginUser", null);
        }

        return map;
    }
    @GetMapping("/users/{userid}")
    public Map<?,?> mypage(@PathVariable String userid){
        var map = new HashMap<>();
        printer.accept("마이페이지에서 넘어온 아이디: "+userid);
        UserDto user = userService.findById(userid);
        if(user != null){
            map.put("message", "SUCCESS");
            map.put("loginUser", user);
        }else{
            map.put("message", "FAILURE");
            map.put("loginUser", null);
        }
        
        return map;
    }
    @PutMapping("/users")
    public Map<?,?> update(@RequestBody UserDto user){
        printer.accept("수정페이지에 넘어온 비번: "+user.getPassword());
        int result = userService.update(user);
        printer.accept("성공 여부: "+result);
        var map = new HashMap<>();
        if(result == 1){
            
            map.put("message", "SUCCESS");
        }else{
            
            map.put("message", "FAILURE");
        }
        return map;
    }
    @DeleteMapping("/users")
    public Map<?, ?> remove(@RequestBody UserDto user){
        printer.accept("회원탈퇴 넘어온 아이디: "+user.getUserid());
        var map = new HashMap<>();
        int result = userService.remove(user);
        if(result == 1){
            map.put("message", "SUCCESS");
        }else{
            map.put("message", "FAILURE");
        }
        return map;
    }
   
}



