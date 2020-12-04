package com.example.demo.impls;

import com.example.demo.domains.UserDto;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired UserRepository userRepository;
    @Autowired UserDto user;
    @Override
    public int join(UserDto user) {
        return userRepository.insert(user);
    }

    @Override
    public UserDto login(UserDto user) {
        return userRepository.login(user);
    }

    @Override
    public UserDto findById(String userid) {
        return userRepository.selectById(userid);
    }

    @Override
    public int update(UserDto user) {
        return userRepository.update(user);
    }

    @Override
    public int remove(UserDto user) {
        return userRepository.delete(user);
    }
    
}
