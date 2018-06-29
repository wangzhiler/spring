package com.qaqa.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by thinkpad on 2018/6/23.
 * <p>
 * 静态工厂方法: 直接调用某一个类的静态方法就可以返回Bean的实例
 */
public class StaticCarFactory {

    private static Map<String, Car> cars = new HashMap<>();

    static {
        cars.put("aaa", new Car("aaa", 300));
        cars.put("bbb", new Car("bbb", 4000));
    }


    //静态工厂方法
    public static Car getCar(String name) {
        return cars.get(name);
    }

}
