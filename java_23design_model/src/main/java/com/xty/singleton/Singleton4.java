package com.xty.singleton;


/**
 * 懒汉式
 * 一开始不会加载到内存，当你需要它时才会创建。
 * 使用synchronized锁机制解决了线程不安全的问题，但同时降低了效率
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4(){

    }
    public void  m(){
        System.out.println("m");
    }

    public static Singleton4 getInstance(){
        //  妄图通过减少同步代码块的方式提高效率并双重检查校验
        if (instance == null){
            synchronized(Singleton4.class){
                if (instance == null){
                    instance = new Singleton4();
                }
            }

        }

        return instance;
    }


    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                    System.out.println(Singleton3.getInstance().hashCode());
            }).start();
        }


    }

}
