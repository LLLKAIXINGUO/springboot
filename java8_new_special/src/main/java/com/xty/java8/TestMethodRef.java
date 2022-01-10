package com.xty.java8;

import com.xty.java8.entity.Employ;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、方法引用 ： 若Lambda 体中的内容有方法已经实现了，我们可以使用"方法引用"
 *          (可以理解为方法引用是Lambda 表达式的另一种表现形式)
 *
 * 主要有三种语法格式：
 *
 * 对象::实例方法名 （注意： Lambda 体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数式列表和返回值类型保持一致  ）
 *
 * 类::静态方法名
 *
 * 类::实例方法名 （前提： 若 Lambda 参数列表中的第一个参数是实例方法的调用者，第二个参数是这个方法的参数值时，才可以使用ClassName::method）
 *
 * 二、构造器引用
 *  格式：ClassName :: new
 *
 *  注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致！
 *
 *  三、数组引用
 *  Type::new
 */
public class TestMethodRef {

    //对象::实例方法名
    @Test
    public  void test01() {
        // 第一版
        PrintStream ps = System.out;
        Consumer<String> con = (x)->ps.println(x);
        con.accept("abc");
        // 第二版
        Consumer<String> consumer = System.out::println;
        consumer.accept("abc");
    }

    @Test
    public void test02() {
        Employ employ = new Employ();
        employ.setAge(11);
        employ.setName("小太阳");
        employ.setSalary(1200.00);
        // 第一版
        Supplier<String> supplier = ()->employ.getName();
        String s = supplier.get();
        System.out.println(s);
        // 第二版
        Supplier<Integer> supplier2 = employ::getAge;
        Integer s1 = supplier2.get();
        System.out.println(s1);
    }

    //类::静态方法名
    @Test
    public void test03() {
        Comparator<Integer> com = (x, y)->Integer.compare(x,y);

        Comparator<Integer> com2 = Integer::compare;
        int compare = com2.compare(1, 2);
        System.out.println(compare);
    }

    //类::实例方法名
    @Test
    public void test04() {
        //
        BiPredicate<String,String> bp = (x,y)->x.equals(y);

        BiPredicate<String,String> bp2 = String::equals;
        System.out.println(bp2.test("abc", "abc"));
    }

    //构造器引用
    @Test
    public void test05() {
        Supplier<Employ> supplier = ()->new Employ();
        //构造器引用方式 用哪个构造器对应接口的方法参数
        Supplier<Employ> supplier2 = Employ::new;
        Employ employ = supplier2.get();
    }

    @Test
    public void test06() {
        //构造器引用方式
        Function<Integer, Employ> function = Employ::new;

        Employ employ = function.apply(11);

        System.out.println(employ);
    }

    //数组引用
    @Test
    public void test07() {
        Function<Integer,String[]> function = (x)->new String[x];
        Function<Integer,String[]> function2 = String[]::new;
        String[] apply = function2.apply(10);
        System.out.println(apply.length);
    }

}
