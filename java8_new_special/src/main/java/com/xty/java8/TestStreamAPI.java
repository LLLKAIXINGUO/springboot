package com.xty.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream流的三个操作步骤：
 *
 * 1. 创建Stream流
 *
 * 2. 中间操作
 *
 * 3. 终止操作(终端操作)
 */

public class TestStreamAPI {

    // 创建流的方式
    @Test
    public void test01(){
        // 1. 可以通过Conllection 系列集合提供的stream()(串行流) 或 parallelStream()(并行流)
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        // 2.通过Arrays中的静态方法 stream(）获取数组流
        Integer[] integers = new Integer[10];
        Stream<Integer> stream2 = Arrays.stream(integers);

        // 3.通过Stream类中的静态方法 of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc", "dd");


        // 4.创建无限流
        // 迭代
        Stream<Integer> stream4 = Stream.iterate(0, x -> x + 2);

        stream4.limit(10)
                .forEach(System.out::println);

        // 生成
        Stream<Double> stream5 = Stream.generate(() -> Math.random());

        stream5.limit(5)    // 中间操作
                .forEach(System.out::println); // 终止操作

    }

}
