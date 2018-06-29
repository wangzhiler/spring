package com.qaqa.spring.aop.xml;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by thinkpad on 2018/6/28.
 * //把这个类声明为一个切面: 需要把该类放入到IOC容器中 再声明为一个切面
 * 可以使用@Order注解指定切面的优先级，值越小优先级越高
 */

public class LoggingAspect2 {

    public void declareJoinPointExecution() {}

    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " begins with " + args);
    }

    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends");
    }

    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends with " + result);
    }

    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " occurs exception with " + ex);
    }


    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {

        Object result = null;
        String methodName = proceedingJoinPoint.getSignature().getName();

        //执行目标方法
        try {
            //前置通知
            System.out.println("The method " + methodName + " begins with "
                    + Arrays.asList(proceedingJoinPoint.getArgs()));
            result = proceedingJoinPoint.proceed();
            //后置通知
            System.out.println("The method " + methodName + " ends with " + result);
        } catch (Throwable e) {
//            e.printStackTrace();
            //异常通知
            System.out.println("The method " + methodName + " occurs exception: " + e);
        }
        //后置通知
        System.out.println("The method " + methodName + " ends");
        return result;
    }


}