package com.xty.singleton;


/**
 * 懒汉式
 * 一开始不会加载到内存，当你需要它时才会创建。
 * 唯一缺点:虽然达到了按需初始化的目的，但却带来了线程不安全的问题
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2(){

    }
    public void  m(){
        System.out.println("m");
    }

    public static Singleton2 getInstance(){
        if (instance == null){
            instance = new Singleton2();
        }

        return instance;
    }


    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton2 = Singleton1.getInstance();

        System.out.println(singleton1 == singleton2);
    }

}
