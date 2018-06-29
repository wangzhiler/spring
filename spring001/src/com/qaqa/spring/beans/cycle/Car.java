package com.qaqa.spring.beans.cycle;

/**
 * Created by thinkpad on 2018/6/23.
 */
public class Car {

    public Car() {
        System.out.println("Car's constructor...");
    }

    private String brand;

    public void setBrand(String brand) {
        System.out.println("setBrand...");
        this.brand = brand;
    }

    public void init() {
        System.out.println("init...");
    }

    public void destroy() {
        System.out.println("destroy...");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
