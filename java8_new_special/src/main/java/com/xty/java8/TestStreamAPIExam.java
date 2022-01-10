package com.xty.java8;

import com.xty.java8.entity.Employ;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStreamAPIExam {
    List<Employ> list = new ArrayList<>(
            Arrays.asList(
                    new Employ("张三",11,10000.0, Employ.Status.FREE),
                    new Employ("李四",22,100000.0, Employ.Status.FREE),
                    new Employ("李四",22,100000.0, Employ.Status.FREE),
                    new Employ("李四",22,100000.0, Employ.Status.BUSY),
                    new Employ("王五",33,1000.0, Employ.Status.VOCATION),
                    new Employ("赵六",44,20000.0, Employ.Status.VOCATION))
    );

    @Test
    public void test2() {

        //2。怎样用map 和reduce方法数一数流中有多少个Employee呢?
        Optional<Integer> reduce = list.stream().map(e -> 1).reduce(Integer::sum);
        System.out.println(reduce.get());


    }

    @Test
    public void test() {

        //1。给定一个数字列表,如何返回一个由每个数的平方构成的列表呢?，
        // 给定【1，2，3，4,5】,应该返回【1，4,9,16，25】。

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> collect = integers.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(collect);

    }

}

