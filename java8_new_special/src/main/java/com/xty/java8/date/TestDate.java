package com.xty.java8.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestDate {

    /**
     * 1.8之前时间对象均是线程不安全的，1.8后引进线程时间对象， LocalDate、LocalTime、LocalDateTime 类的实
     * 例是不可变的对象，分别表示使用 ISO-8601日
     * 历系统的日期、时间、日期和时间。它们提供
     * 了简单的日期或时间，并不包含当前的时间信 息。也不包含与时区相关的信息
     */
    @Test
    public void test() throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

       /* Callable<Date> callable = new Callable<Date>() {
            @Override
            public Date call() throws Exception {

                System.out.println(sdf.toString());
                return sdf.parse("20211230"); // 线程不安全
            }
        };*/

        Callable<Date> callable = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                return DateFormatThreadLocal.convert("20211231"); // 线程安全
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Date>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(pool.submit(callable));
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get());
        }
        pool.shutdown();
    }

    @Test
    public void test02() throws ExecutionException, InterruptedException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 运用java8 提供的线程安全的时间类
        Callable<LocalDate> callable = new Callable<LocalDate>() {
            @Override
            public LocalDate call() throws Exception {
                return LocalDate.parse("20211231",dtf); // 线程安全
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<LocalDate>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(pool.submit(callable));
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get());
        }
        pool.shutdown();

    }

}
