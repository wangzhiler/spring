package com.qaqa.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by thinkpad on 2018/6/23.
 *
 * 实例工厂方法: 实例工厂的方法, 即现需要创建工厂本身, 再调用工厂的实例方法来返回bean实例
 */
public class InstanceCarFactory {
    private Map<String, Car> cars = null;

    public InstanceCarFactory() {
        cars = new HashMap<>();
        cars.put("aaa", new Car("aaa", 30));
        cars.put("bbb", new Car("bbb", 40));

    }

    public Car getCar(String brand) {
        return cars.get(brand);
    }
}
