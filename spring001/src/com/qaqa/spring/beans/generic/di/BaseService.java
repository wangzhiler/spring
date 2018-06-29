package com.qaqa.spring.beans.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by thinkpad on 2018/6/28.
 */
public class BaseService<T> {

    @Autowired
    protected BaseRepository<T> repository; //这样的注解会被子类继承



    public void add() {
        System.out.println("add");
        System.out.println(repository);
    }
}
