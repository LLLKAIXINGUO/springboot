package com.xty.singleton;


/**
 * 静态内部类的方式
 *  JVM保证单例
 *  加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class Singleton5 {

    private Singleton5(){

    }
    public void  m(){
        System.out.println("m");
    }


    private static class Singleton5Holder{
        private static Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getInstance(){

        return Singleton5Holder.INSTANCE;
    }


    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                    System.out.println(Singleton4.getInstance().hashCode());
            }).start();
        }


    }

}
