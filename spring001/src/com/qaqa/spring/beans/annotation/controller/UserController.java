package com.qaqa.spring.beans.annotation.controller;

import com.qaqa.spring.beans.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by thinkpad on 2018/6/23.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void execute() {
        System.out.println("UserController execute...");
        userService.add();

    }
}
