package com.qaqa.spring.beans.spel;

/**
 * Created by thinkpad on 2018/6/22.
 */
public class Car {
    private String brand;
    private double price;

    private double tyrePerimeter;

    public Car() {
        System.out.println("Car's Constructor...");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", tyrePerimeter=" + tyrePerimeter +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTyrePerimeter() {
        return tyrePerimeter;
    }

    public void setTyrePerimeter(double tyrePerimeter) {
        this.tyrePerimeter = tyrePerimeter;
    }
}
