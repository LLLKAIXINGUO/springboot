package com.xty.fourFunctionInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8 内置的四大核心函数式接口
 *
 * Comsumer<T> : 消费型接口
 *      void accept(T t);
 *
 * Supplier<T> : 供给型接口
 *      T get();
 *
 * Function<T,R> : 函数型接口
 *      R apply(T t);
 *
 *  Predicate<T> : 断言型接口
 *      boolean test(T t)
 */

public class TestLambda {


    public static void main(String[] args) {

        //Comsumer<T> : 消费型接口
        happy(1.2,(x)-> System.out.println("花了"+x+"元去happy"));

        //Supplier<T> : 供给型接口
        List<Integer> integer = getInteger(10, () -> (int) (Math.random() * 100));
        integer.forEach((i)-> System.out.print(i+" "));

        //Function<T,R> : 函数型接口
        String trim = trim("  \t\t\t\t  小 明 拉 了  决 胜 巅 峰 理 解  是       ", (str) -> str.trim());
        String trim2 = trim("小 明 拉 了  决 胜 巅 峰 理 解  是       ", (str) -> str.substring(5));

        System.out.println(trim2);


        //Predicate<T> : 断言型接口
        List<String> strings = Arrays.asList("abc","abcd","lll","abcde","cnm","cnb");
        List<String> list = filterStr(strings, (str) -> str.contains("abc"));
        list.forEach((s)-> System.out.println(s+" "));

    }

    public static void happy(Double money, Consumer<Double> consumer){
        consumer.accept(money);
    }


    // 需求：产生指定个数的整数
    public static List<Integer> getInteger(int num,Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            //产生整数并加到集合中去
            list.add( supplier.get());
        }
        return list;
    }

    // 需求：用于处理字符串
    public static String trim(String str, Function<String,String> function){

        return function.apply(str);
    }

    // 需求：将满足需求的字符串，放入集合中

    public static List<String> filterStr(List<String> listStr, Predicate<String> predicate){
        List<String> list = new ArrayList<>();
        for (String s : listStr) {
            // 判断是否满足条件
            if (predicate.test(s)){
                list.add(s);
            }
        }

        return list;
    }
}
