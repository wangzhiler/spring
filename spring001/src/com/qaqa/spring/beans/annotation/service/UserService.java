package com.qaqa.spring.beans.annotation.service;

import com.qaqa.spring.beans.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by thinkpad on 2018/6/23.
 */

@Service
public class UserService {

    //    @Autowired
//    @Qualifier("userRepositoryImpl")
    private UserRepository userRepository;

    @Autowired
//    @Qualifier("userRepositoryImpl")
    public void setUserRepository(@Qualifier("userRepositoryImpl")UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add() {
        System.out.println("UserService add...");
        userRepository.save();

    }
}
