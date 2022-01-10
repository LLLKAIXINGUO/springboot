package com.xty.java8.date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class TestLocalDateTime {

    /**
     * ZonedDate、ZonedTime、ZonedDateTime
     */
    @Test
    public void test6(){
        //ZoneId.getAvailableZoneIds()  可以获取所有时区时区信息


    }

    /**
     * DateTimeFormatter : 格式化时间/日期
     */
    @Test
    public void test5(){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日");

        LocalDateTime ldt = LocalDateTime.now();

        String format = dtf.format(ldt); // 日期转换为规定的格式字符串
        LocalDateTime parse = ldt.parse(format, dtf); // 字符串按照规定的格式转换为日期
        System.out.println(format);
        System.out.println(ldt.format(dtf));

    }

    /**
     * 4.TemporalAdjuster : 时间校正器
     */
    @Test
    public void test4(){

        LocalDateTime localDateTime= LocalDateTime.now();


        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(10);
        System.out.println("这个月第10天日期为"+localDateTime1);
        LocalDateTime with = localDateTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)); //获取下一个周五的日期时间

        System.out.println(with);

        // 自定义 获取下一个工作日
        LocalDateTime with1 = localDateTime.with((l) -> {
            LocalDateTime ldt = (LocalDateTime) l;

            int value = ldt.getDayOfWeek().getValue();

            if (DayOfWeek.FRIDAY.getValue() == value) {
                return ldt.plusDays(3);
            } else if (DayOfWeek.SATURDAY.getValue() == value) {
                return ldt.plusDays(2);
            } else {
                return ldt.plusDays(1);
            }

        });


        System.out.println(with1);

    }

    /**
     * 3.
     * Duration : 计算两个"时间"直接的间隔
     * Period : 计算两个"日期"之间的间隔
     */
    @Test
    public void test3(){

        LocalTime localTime2 = LocalTime.now();
        LocalTime localTime = LocalTime.of(15,14,55);

        System.out.println(Duration.between(localTime,localTime2).toMillis());

        LocalDate localDate2 = LocalDate.now();
        LocalDate localDate = LocalDate.of(2012,11,22);

        System.out.println(Period.between(localDate,localDate2).getDays());

    }


    /**
     * 2.Instant : 时间戳(以Unix 元年：1970年1月1日 00:00:00到某个时间之间的毫秒值)
     */
    @Test
    public void test2(){

        Instant instant = Instant.now();
        System.out.println(instant); //默认获取 UTC(美国) 时区

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8)); // 偏移时间后得到的时间
        System.out.println(offsetDateTime);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant2 = Instant.now();
        System.out.println(instant2.toEpochMilli()); // 获取毫秒值
        System.out.println(Duration.between(instant,instant2));
    }


    /**
     * 不变的时间日期类
     * LocalDateTime  综合处理时间日期类 plus 加时间日期 ，minus 减时间日期
     * LocalDate   处理日期的类
     * LocalTime  处理时间的类
     */
    @Test
    public void test(){

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime now2 = LocalDateTime.of(2016,11,12,13,14,30);
        System.out.println(now);
        System.out.println(now2.plusDays(2));

    }

}
