package com.qaqa.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by thinkpad on 2018/6/28.
 */

public class ValidationAspect {

    public void validateArgs(JoinPoint joinPoint) {
        System.out.println("-->validate: " + Arrays.asList(joinPoint.getArgs()));
    }
}
