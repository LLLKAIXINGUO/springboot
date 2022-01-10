package com.xty.singleton;



/**
 * 枚举单例模式
 *  不仅可以解决线程同步，还可以防止反序列化
 */
public enum Singleton6 {

    INSTANCE;
    public void  m(){
        System.out.println("m");
    }

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                    System.out.println(Singleton5.getInstance().hashCode());
            }).start();
        }


    }

}
