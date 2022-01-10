package com.xty.java8;

import com.xty.java8.entity.Employ;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


/**
 * 终止操作
 */
public class TestStreamAPI3 {

    List<Employ> list = new ArrayList<>(
            Arrays.asList(
                    new Employ("张三",11,10000.0, Employ.Status.FREE),
                    new Employ("李四",22,100000.0,Employ.Status.FREE),
                    new Employ("李四",22,100000.0,Employ.Status.FREE),
                    new Employ("李四",22,100000.0,Employ.Status.BUSY),
                    new Employ("王五",33,1000.0,Employ.Status.VOCATION),
                    new Employ("赵六",44,20000.0,Employ.Status.VOCATION))
    );
    /*
        收集
        collect —> 将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法.
     */

    @Test
    public void test10() {
        // 连接字符
        String collect = list.stream()
                .map(Employ::getName)
                .collect(Collectors.joining(","));
        System.out.println(collect);
    }

    // 求和
    @Test
    public void test9() {
        // 员工工资的聚合函数结果
        DoubleSummaryStatistics collect = list.stream().collect(Collectors.summarizingDouble(Employ::getSalary));
        System.out.println(collect.getSum());
    }

    // 分区
    @Test
    public void test8() {
        Map<Boolean, List<Employ>> collect = list.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 10000));

        System.out.println(collect);
    }

    // 多级分组
    @Test
    public void test7() {
        Map<Employ.Status, Map<String, List<Employ>>> map = list.stream()
                .collect(Collectors
                        .groupingBy(Employ::getStatus,
                                Collectors.groupingBy((Employ e) -> {
                                    if (e.getAge() <= 35) {
                                        return "青年";
                                    } else if (e.getAge() <= 50) {
                                        return "中年";
                                    } else {
                                        return "老年";
                                    }

                                })));

        System.out.println(map);
    }

    //按照状态分组
    @Test
    public void test6() {

        Map<Employ.Status, List<Employ>> collect = list.stream().collect(Collectors.groupingBy(Employ::getStatus));

        System.out.println(collect);
    }

    @Test
    public void test5() {

        // 收集总数
        Long collect = list.stream().collect(Collectors.counting());
        System.out.println(collect);

        // 平均值

        Double ageAvg = list.stream().collect(Collectors.averagingInt(Employ::getAge));
        System.out.println(ageAvg);
    }
    
    @Test
    public void test4() {

        List<String> stringList = list.stream()
                .map(Employ::getName)
                .collect(Collectors.toList());
        System.out.println(stringList);

        HashSet<String> strings = list.stream()
                .map(Employ::getName)
                .collect(Collectors.toCollection(HashSet::new));

        System.out.println(strings);

        // 根据名字字段去重集合
        TreeSet<Employ> collect = list.stream()
                .collect(Collectors.
                        toCollection(() ->
                                new TreeSet<Employ>(Comparator.comparing(Employ::getName))));

        System.out.println(collect);
    }

    /*
        归约 identity -> 起始值  Binary0perator -> 操作方法
        reduce(T identity，BinaryOperator) / reduce(Binary0perator)—可以将流中元素反复结合起来，得到一个值。
     */

    @Test
    public void test3() {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 利用规约求和
        /*
            reduce(0, (x, y) -> x + y) 解析
            先将0->x ，再将流中每个元素->y，然后执行x+y操作
            接着将x+y结果作为x ,再从流中取下一个元素作为y 。循环操作，直至流中最后一个元素
         */
        Integer sum = integers.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        // 利用规约求员工工资总和
        Optional<Double> reduce = list.stream().map(Employ::getSalary)
                .reduce(Double::sum);
        System.out.println(reduce);
    }

    /**
     * 查找与匹配
     * allMatch—检查是否匹配所有元素
     * anyMatch—检查是否至少匹配一个元素
     * noneMatch——检查是否没有匹配所有元素
     * findFirst——返回第一个元素
     * findAny——返回当前流中的任意元素
     * count—返回流中元素的总个数
     * max——返回流中最大值
     * min——返回流中最小值
     */
    @Test
    public void test2() {

        long count = list.stream().count();

        // 提取员工中最小工资
        Optional<Double> min = list.stream().map(Employ::getSalary)
                .min(Double::compare);
        System.out.println(min.get());

    }

    @Test
    public void test1() {

        System.out.println(list.stream().allMatch(employ -> employ.getStatus().equals(Employ.Status.BUSY)));
        System.out.println(list.stream().anyMatch(employ -> employ.getStatus().equals(Employ.Status.BUSY)));
        System.out.println(list.stream().noneMatch(employ -> employ.getStatus().equals(Employ.Status.BUSY)));


        // 按薪资排序，找出最高薪资员工
        Optional<Employ> first = list.stream()
                .sorted((e1, e2) -> -Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();

        System.out.println(first.get());

        // 找出随机一个空闲员工
        // parallelStream 并行流
        Optional<Employ> any = list.parallelStream()
                .filter(employ -> employ.getStatus().equals(Employ.Status.FREE))
                .findAny();
        System.out.println(any.get());

    }
    
}
