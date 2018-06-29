package com.qaqa.spring.beans.annotation;

import com.qaqa.spring.beans.annotation.controller.UserController;
import com.qaqa.spring.beans.annotation.repository.UserRepository;
import com.qaqa.spring.beans.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by thinkpad on 2018/6/23.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
//        TestObject to = (TestObject) ctx.getBean("testObject");
//        System.out.println(to);
//
        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println(userController);
        userController.execute();
//
//
//        UserService userService = (UserService) ctx.getBean("userService");
//        System.out.println(userService);
//
//        UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");
//        System.out.println(userRepository);
    }
}
