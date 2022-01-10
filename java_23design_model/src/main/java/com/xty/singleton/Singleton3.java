package com.xty.singleton;


/**
 * 懒汉式
 * 一开始不会加载到内存，当你需要它时才会创建。
 * 使用synchronized锁机制解决了线程不安全的问题，但同时降低了效率
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3(){

    }
    public void  m(){
        System.out.println("m");
    }

    public static synchronized Singleton3 getInstance(){
        if ( instance == null){
            instance = new Singleton3();
        }

        return instance;
    }


    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                    System.out.println(Singleton2.getInstance().hashCode());
            }).start();
        }


    }

}
