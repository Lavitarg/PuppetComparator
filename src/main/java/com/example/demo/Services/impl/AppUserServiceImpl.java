package com.example.demo.Services.impl;

import com.example.demo.Entities.AppUser;
import com.example.demo.Entities.Role;
import com.example.demo.Repository.AppUserRepository;
import com.example.demo.Services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository userRepository;

    @Override
    public boolean saveUniqUser(AppUser user) {
        if(userRepository.findByUsername(user.getUsername()) == null){
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));
            userRepository.save(user);
            return true;
        } else{
            return false;
        }
    }
}
