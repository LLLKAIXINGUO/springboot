package com.xty.abstractfactory;




/**
 *
 * 抽象工厂
 *
 */
public class Test {
    public static void main(String[] args) {

        AbstractFactory factory = new ModernFactory(); // 创建现代人工厂

        Food food = factory.createFood(); // 创建现代人产品 根据上面的工厂所创建所对应的产品
        food.printName();
        Vehicle vehicle = factory.createVehicle();
        vehicle.go();
        Weapon weapon = factory.createWeapon();
        weapon.shoot();


    }
}
