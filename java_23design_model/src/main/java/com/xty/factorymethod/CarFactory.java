package com.xty.factorymethod;

/**
 * 工厂方法
 */
public class CarFactory {

    public Moveable createCar(){

        System.out.println("日志操作");
        return new Car();
    }

}
