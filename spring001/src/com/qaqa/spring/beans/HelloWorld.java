package com.qaqa.spring.beans;

/**
 * Created by thinkpad on 2018/6/21.
 */
public class HelloWorld {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("hello: " + name);
    }
}
