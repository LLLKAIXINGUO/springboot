package com.xty.factorymethod;

// 简单的交通工具工厂类

/**
 *  优点 ：简单
 *
 *  缺点 ： 扩展性并不好
 */
public class SimpleVehicleFactory {


    public Car createCar(){
        // before processing
        return new Car();
    }

    public Plane createPlane(){
        // before processing
        return new Plane();
    }

}
