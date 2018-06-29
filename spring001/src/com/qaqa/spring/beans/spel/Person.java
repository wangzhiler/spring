package com.qaqa.spring.beans.spel;

/**
 * Created by thinkpad on 2018/6/22.
 */
public class Person {
    private String name;
    private Car car;

    //引用address bean的city属性
    private String city;

    //根据car的price 确定info: car的price>=300 gold
    //否则为 silver
    private String info;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", city='" + city + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
