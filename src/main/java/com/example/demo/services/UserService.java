package com.example.demo.services;

import com.example.demo.domains.UserDto;

import org.springframework.stereotype.Component;

@Component
public interface UserService {

	public int join(UserDto user);

	public UserDto login(UserDto user);

	public UserDto findById(String userid);

	public int update(UserDto user);

	public int remove(UserDto user);
    
}
