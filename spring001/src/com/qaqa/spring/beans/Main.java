package com.qaqa.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by thinkpad on 2018/6/21.
 */
public class Main {
    public static void main(String[] args) {
        /*
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName("qwer");
        helloWorld.hello();
        */

        //创建对象以及给对象赋值可以让spring来完成

        //spring的步骤
        //1. 创建spring的IOC容器对象
        // ApplicationContext 代表IOC容器,实质为借口
        // ClassPathXmlApplicationContext：是ApplicationContext接口的实现类,该实现类从类路径下来加载配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2. 从ioc容器总获取Bean实例
//        利用类型返回IOC容器中的Bean,但要求IOC容器中必须只能有一个该类型的Bean
//        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
//        利用id定位到IOC容器中的Bean
        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld123");

        helloWorld.hello();

        Car car = (Car) ctx.getBean("car");

        System.out.println(car);

        car = (Car) ctx.getBean("car2");
        System.out.println(car);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

        person = (Person) ctx.getBean("person2");
        System.out.println(person);
    }
}
