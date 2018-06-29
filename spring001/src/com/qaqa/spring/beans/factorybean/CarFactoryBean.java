package com.qaqa.spring.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by thinkpad on 2018/6/23.
 */

//自定义的FactoryBean 需要实现FactoryBran接口
public class CarFactoryBean implements FactoryBean<Car> {


    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    //返回bean的对象
    @Override
    public Car getObject() throws Exception {
        return new Car(brand,50);
    }

    //返回bean的类型
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    //是不是单实例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
