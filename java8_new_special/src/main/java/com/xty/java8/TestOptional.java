package com.xty.java8;

import com.xty.java8.entity.Employ;
import com.xty.java8.entity.GodNess;
import com.xty.java8.entity.Man;
import com.xty.java8.entity.NewMan;
import org.junit.Test;

import java.util.Optional;

public class TestOptional {

    /**
     * Optional<T> 类(java.util.Optional) 是一个容器类，代表一个值存在或不存在，
     *  原来用 null 表示一个值不存在，现在 Optional 可以更好的表达这个概念。并且可以避免空指针异常。
     * Optional容器类的常用方法:
         * Optional.of(T t) :创建一个Optional实例
         * Optional.empty() :创建一个空的 Optional实例
         * Optional. ofNullable(T t):若t不为nu1l,创建optional实例，否则创建空实例
         * isPresent() :判断是否包含值
         * orElse(T t) :如果调用对象包含值， 返回该值,否则返回t
         * orElseGet(Supplier s) :如果调用对象包含值， 返回该值，否则返回s获取的值
         * map(Function f):如果有值对其处理，并返回处理后的Optional,否则返回Optional.empty()
         * flatMap(Function mapper):与 map类似，要求返回值必须是Optional
     */


    @Test
    public void test01(){

        Optional<Employ> op = Optional.ofNullable(null);

        System.out.println(op.get());
    }

    @Test
    public void test02(){
        Optional<Employ> op = Optional.ofNullable(null);

        Employ employ = op.orElse(new Employ(11, 14.5));
        Employ employ2 = op.orElseGet(() -> {
            System.out.println("方法逻辑");
            return new Employ(11, 14.5);
        });
        System.out.println(employ2);
    }
    
    
    @Test
    public void test03(){
        Optional<Employ> opp = Optional.ofNullable(new Employ(11, 14.5));



        Optional<Integer> age = opp.flatMap((e) -> Optional.ofNullable(e.getAge()));

        System.out.println(age.get());
    }

    @Test
    public void test04(){

        Man man = new Man();

        String age = getName(man);
        System.out.println(age);

        Optional<NewMan> op = Optional.ofNullable(null);

        String name2 = getName2(op);
        System.out.println(name2);

    }


    public String getName(Man man){
        if (man != null){
            GodNess godness = man.getGodness();
            if (godness != null){
                return godness.getName();
            }
        }
        return "小红";
    }

    public String getName2(Optional<NewMan> man){




        return  man.orElse(new NewMan())
                .getGodness()
                .orElse(new GodNess("小静"))
                .getName();
    }

}
