package com.xty.java8;

import com.xty.java8.entity.Employ;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamAPI2 {

    List<Employ> list = new ArrayList<>(
            Arrays.asList(
                    new Employ(11,10000.0),
                    new Employ(22,10000.0),
                    new Employ(33,1000.0))
    );

    // 中间操作

    /**
     * 排序
     * sorted() --- 自然排序(Comparable)
     * sorted(Comparator com) ----- 定制排序（Comparator）
     */

    @Test
    public void test5(){
        List<String> strings = Arrays.asList("bbb","aaa","ddd","ccc");
        // 自然排序
        strings.stream().sorted().forEach(System.out::println);

        // 定制排序
        list.stream().sorted((e1,e2)->{
            if (e1.getAge().equals(e2.getAge())){
                return e1.getName().compareTo(e2.getName());
            }else {
                return e1.getAge().compareTo(e2.getAge());
            }
        }).forEach(System.out::println);
    }

    /**
     * 映射
     * map————接收Lambda ，将元素转换成其他形式或掇取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap—接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */

    @Test
    public void test4(){
        List<String> strs = Arrays.asList("aaa","bbb","ccc","ddd");

        strs.stream()
            .map(str->str.toUpperCase())
            .forEach(System.out::println);

        System.out.println("---------------------");

        list.stream()
                .map(Employ::getAge)
                .forEach(System.out::println);
        System.out.println("---------------------");

       /*
       Stream<Stream<Character>> streamStream = strs.stream()
                                                .map(TestStreamAPI2::filterCharacter); //{{a,a,a},{b,b,b},....}}
        streamStream.forEach(strm -> strm.forEach(
                System.out::println
        ));
        */

        strs.stream().flatMap(TestStreamAPI2::filterCharacter).forEach(System.out::println);


    }

    public static Stream<Character> filterCharacter(String str){

        List characters = new ArrayList<Character>();

        for(Character c : str.toCharArray()){
            characters.add(c);
        }


        return characters.stream();

    }
     /*
            筛选与切片
            filter—接收Lambda，从流中排除某些元素。
            limit——截断流，使其元素不超过给定数量。
            skip(n)一跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n 个，则返回一个空流。与limit(n〉互补
            distinct—筛选，通过流所生成元素的hashCode(）和equals(）去除重复元素
     */
    //内部迭代:迭代操作由 Stream API完成

    @Test
    public void test3(){
        list.stream()
                .filter(e -> {
                    System.out.println("短路");  // 相当于 && ||
                    return e.getAge()>10;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void test(){
        // 中间操作：不会执行任何操作
         list.stream().filter(e -> {
            //System.out.println("Stream API 中间操作");
            return e.getAge() > 20;
        }).forEach(e->{
            e.setSalary(100.0);
             System.out.println(e);
        });

        // 终止操作：一次性执行全部内容，即“惰性求值”
       /* stream.forEach(e->{
            e.setSalary(100.0);
            System.out.println(e);
        });*/

        System.out.println(list);
    }

    // 外部迭代
    @Test
    public void test2(){
        Iterator<Employ> iterator = list.iterator();

        while (iterator.hasNext()){
            Employ e = iterator.next();
            if (e.getAge()>22){
                System.out.println(e);
            }
        }


    }

}
