package com.xty.factorymethod;

/**
 * 任何可以产生对象的方法或类，都可以称之为工厂
 * 单例也是一种工厂
 *
 * 为什么有了new之后，还要有工厂
 *    - 灵活控制生产过程
 *    - 权限、修饰、日志....
 *
 */
public class Test {
    public static void main(String[] args) {
        Moveable moveable = new CarFactory().createCar();

        moveable.go();
    }
}
