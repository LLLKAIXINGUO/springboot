package com.xty.java8;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class TestForkJoinCalculate {

    /**
     * Fork/Join 框架 数据量越大，效率体现的越明显
     */
    @Test
    public void test01(){
        Instant now = Instant.now();

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinTask<Long> forkJoinTask = new ForkJoinCalculate(0,100000000000L);

        Long result = forkJoinPool.invoke(forkJoinTask);

        System.out.println(result);

        Instant end = Instant.now();

        System.out.println("耗费时间为："+ Duration.between(now,end).toMillis() + "ms");
    }

    /**
     * 普通for循环
     */
    @Test
    public void test02(){
        Instant now = Instant.now();
        long sum = 0;
        for (long i = 0; i <= 100000000000L; i++){
            sum += i;
        }

        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println("耗费时间为："+ Duration.between(now,end).toMillis() + "ms");
    }


    /**
     * java8 并行流
     */

    @Test
    public void test03(){

        Instant now = Instant.now();
        // 构造一个n到m的序列
        long sum = LongStream.rangeClosed(0, 100000000000L)
                .parallel() //变为并行流 Fork/Join 底层
                //.sequential() 变为串行流
                .reduce(0, Long::sum);
        System.out.println(sum);

        Instant end = Instant.now();

        System.out.println("耗费时间为："+ Duration.between(now,end).toMillis() + "ms");
    }
}
