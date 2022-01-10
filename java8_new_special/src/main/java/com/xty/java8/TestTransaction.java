package com.xty.java8;

import com.xty.java8.entity.Trader;
import com.xty.java8.entity.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestTransaction {

    List<Transaction> transactions = null;

    @Before
    public void before(){
        Trader zs = new Trader("张三","上海");
        Trader ls = new Trader("李四","北京");
        Trader ww = new Trader("王五","重庆");
        Trader zl = new Trader("赵六","武汉");
        Trader yq = new Trader("袁七","武汉");
        Trader lb = new Trader("李八","北京");

        transactions = Arrays.asList(
                new Transaction(zs,2011,300),
                new Transaction(ls,2012,1000),
                new Transaction(ww,2011,400),
                new Transaction(zl,2012,710),
                new Transaction(yq,2012,700),
                new Transaction(lb,2013,900)
                );
    }

    @Test
    public void test1() {
        //1.找出2011年发生的所有交易,并按交易额排序（从低到高)

        List<Transaction> collect = transactions.stream()
                .filter(t -> t.getYear().equals(2011))
                .sorted((t, t2) -> Integer.compare(t.getValue(),t2.getValue()))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test2() {
        //2.交易员都在哪些不同的城市工作过?
      /*  HashSet<String> collect = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .collect(Collectors.toCollection(HashSet::new));
*/
        List<String> collect1 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(collect1);
    }
    @Test
    public void test3() {
        //3.查找所有来自武汉的交易员,并按姓名排序
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("武汉"))
                .sorted((t,t2) -> t.getName().compareTo(t2.getName()))
                .forEach(System.out::println);
    }

    @Test
    public void test4() {
        //4.返回所有交易员的姓名字符串,按字母顺序排序
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted(String::compareTo)
                .forEach(System.out::println);

        String reduce = transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .reduce("", (s1, s2) -> s1 + s2);
        System.out.println(reduce);

    }

    @Test
    public void test5() {
        //5．有没有交易员是在北京工作的?
        boolean b = transactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(t -> t.getCity().equals("北京"));

        System.out.println(b);
    }

    @Test
    public void test6() {
        //6.打印生活在北京的交易员的所有交易额
        Integer sum = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("北京"))
                .collect(Collectors.summingInt(Transaction::getValue));

        Optional<Integer> sum2 = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("北京"))
                .map(Transaction::getValue)
                .reduce(Integer::sum);

        System.out.println(sum2.get());
    }

    @Test
    public void test7() {
        //7.所有交易中,最高的交易额是多少
        Optional<Integer> collect = transactions.stream()
                .map(Transaction::getValue)
                .collect(Collectors.maxBy(Integer::compareTo));

        System.out.println(collect.get());
    }

    @Test
    public void test8() {
        //8.找到交易额最小的交易
        Optional<Transaction> collect = transactions.stream()
                .collect(Collectors.minBy((t1, t2) -> t1.getValue().compareTo(t2.getValue())));
        System.out.println(collect);
    }
}
