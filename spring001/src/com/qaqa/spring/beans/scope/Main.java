package com.qaqa.spring.beans.scope;

import com.qaqa.spring.beans.autowire.Address;
import com.qaqa.spring.beans.autowire.Car;
import com.qaqa.spring.beans.autowire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by thinkpad on 2018/6/23.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-scope.xml");

        Car car = (Car) ctx.getBean("car");
        Car car2 = (Car) ctx.getBean("car");

        System.out.println(car == car2); //true
    }
}
