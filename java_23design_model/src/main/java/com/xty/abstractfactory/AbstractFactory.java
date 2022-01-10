package com.xty.abstractfactory;

//形容词用接口   名词用抽象类
public abstract class AbstractFactory {

    abstract Food createFood();

    abstract Weapon createWeapon();

    abstract Vehicle createVehicle();

}
