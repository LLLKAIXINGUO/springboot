package com.xty.java8;


/**
 * java8中，接口新增了允许有自己的默认方法和静态方法
 */
public interface MyFun2 {

    default String getName(){
        return "接口2名字";
    }

    static void sayHi(){
        System.out.println("hello !");
    }

}
