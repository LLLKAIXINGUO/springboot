package com.xty.strategy;

import java.util.Arrays;


/**
 * 策略模式 ： 封装的是做一件事情的时候，不同的执行方式
 * @param <T>
 */
public class Sorter<T> {

    public void sort(T[] arr,Comparator<T> comparator){

        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i; // 最小值下标
            for (int j = i+1; j < arr.length; j++) {
                if (comparator.compareTo(arr[j],arr[minIndex]) < 0){
                  minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
        
    }

    public void swap(T[] arr,int i,int j){
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {
//
//        int[] arr = {7,4,5,9,2,3};
//        Sorter.sort(arr);

        Cat[] cats ={new Cat(7,8),new Cat(4,3),new Cat(2,5)};

        Sorter<Cat> sorter = new Sorter();
        sorter.sort(cats,(t1,t2)->{
            if (t1.getHeight() > t2.getHeight()) return 1;
            if (t1.getHeight() == t2.getHeight()) return 0;
            else return -1;
        });
        System.out.println(Arrays.toString(cats));
    }
}
