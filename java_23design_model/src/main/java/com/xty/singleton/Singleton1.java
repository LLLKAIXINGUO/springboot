package com.xty.singleton;


/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例， JVM 保证线程安全
 * 简单实用，推荐实用!
 * 唯一缺点:不管用到与否，类装载时就完成实例化
 */
public class Singleton1 {

    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){

    }
    public void  m(){
        System.out.println("m");
    }

    public static Singleton1 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(Singleton6.INSTANCE.hashCode());
            }).start();
        }


    }
}
