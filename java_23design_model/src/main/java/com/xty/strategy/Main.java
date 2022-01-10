package com.xty.strategy;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {


        System.out.println(Arrays.toString(twoSum(new int[]{3,1,4,3},  6)));


    }

    public static int[] twoSum(int[] nums, int target) {

        int numIndex = 0; //数字1下标
        int num2Index = 0; // 数字2下标
        // 双重循环 循环极限为(n^2-n)/2
        for(int i = 0; i < nums.length; i++){
            for(int j = nums.length - 1; j > i; j --){
                if(nums[i]+nums[j] == target){
                    numIndex = i;
                    num2Index = j;
                    return new int[]{num2Index,numIndex};
                }
            }
        }

        return new int[]{num2Index,numIndex};
    }

    public static int[] twoSum2(int[] nums, int target) {

        int numIndex = 0; //数字1下标
        int num2Index = 0; // 数字2下标

        // 定义一个hashMap
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            // 每次判断这个数是否是hash里面包含补数，如果是，就记录该数和补数的下标返回
            if(hash.containsKey(nums[i])){
                numIndex = i;
                num2Index = hash.get(nums[i]);
                return new int[]{num2Index,numIndex};
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }

        return new int[]{num2Index,numIndex};
    }

}
