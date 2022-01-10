package com.xty.unit4;

import lombok.ToString;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class TestDate {


    /**
     *  遍历打印日历一个月的天数
     */
    @Test
    public void testDate(){

        //LocalDate now = LocalDate.now();
        for (int j = 1 ;  j<=12 ;  j++){
            LocalDate now = LocalDate.of(2021,  j, 12);

            int monthValue = now.getMonthValue(); // 获取月份
            int dayOfMonth = now.getDayOfMonth(); // 当前日期是该月的第几天

            now = now.minusDays(dayOfMonth -1); // 将其日期改为当月的第一天
            System.out.println(" 一\t 二\t 三\t 四\t 五\t 六\t 日\t");
            int week = now.getDayOfWeek().getValue();// 获取当前日期是星期几
            for(int i = 1; i < week; i++){
                System.out.print("\t");
            }

            while ( now.getMonthValue() == monthValue ){ // 判断是否是当前月
                System.out.printf("%3d",now.getDayOfMonth()); // 打印当月每一天

                if (now.getDayOfMonth() == dayOfMonth){ // 标记当前是该月的某一天
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
                now = now.plusDays(1); // 当前日期加一天
                if (now.getDayOfWeek().getValue() == 1) //如果到了下个星期一就换行
                    System.out.println();
            }

            if (now.getDayOfWeek().getValue() != 1)
                System.out.println();
        }


    }



    @Test
    public void test2(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        List<String> newList = new ArrayList<>();
        List<String> collect = list.stream().map((x) -> x.toUpperCase()).collect(Collectors.toList());

        System.out.println(collect);
        /*Iterator<String> iterator = stringStream.iterator();
        while (iterator.hasNext()){
            newList.add(iterator.next());
        }

        System.out.println(newList);*/

    }

    @Test
    public void test(){
        /*TestStatic testStatic = new TestStatic();
        System.out.println();*/
        Value value = new Value("zs",12);

        testValue(value);
        System.out.println(value);

        String a = "hello world";
        String b = "hello world";
        System.out.println(a == b);
        b = "hello world!";
        System.out.println(a == b);
        System.out.println(a + " ---" + b);
    }

    public void testValue( Value value){
        value.name = "李四";
        value.age = 15;

        System.out.println(value);
    }
    class Value{
         String name;
         Integer age;

         public Value(String n,Integer a){
             name = n;
             age = a;
         }

        @Override
        public String toString() {
            return "Value{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @Test
    public void test6(){
        String str = "1,2,3,6,5,4";

        String[] split = str.split(",");
        Arrays.sort(split,String::compareTo);

        System.out.println(Arrays.toString(split));
    }
}
