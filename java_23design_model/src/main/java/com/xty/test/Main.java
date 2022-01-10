package com.xty.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

   @Test
    public void test(){
       String str = "1,123,12,13,14,1188";


       String[] split = str.split(",");
       Arrays.stream(split).map(s -> Integer.parseInt(s)).sorted().forEach(System.out::println);


       String ss = "1";

       Integer i = new Integer(1);
      System.out.println("1".equals(i));
      System.out.println(ss.equals(i));
     /*  List list = new ArrayList(Arrays.asList(split));*/
   }

}
