package com.qaqa.spring.beans.relation;

import com.qaqa.spring.beans.autowire.Address;
import com.qaqa.spring.beans.autowire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by thinkpad on 2018/6/23.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");
//        Address address = (Address) ctx.getBean("address");
//        System.out.println(address);

        Address address = (Address) ctx.getBean("address2");
        System.out.println(address);

        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }
}
