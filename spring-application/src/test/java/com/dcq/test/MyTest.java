package com.dcq.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dcq.pojo.ScNumberFilter;
import com.dcq.pojo.Student;
import com.dcq.pojo.StudentCopy;
import org.junit.Test;
import org.junit.experimental.theories.FromDataPoints;
import org.springframework.util.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.*;

public class MyTest {

    @Test
    public void Test00(){
    }



    @Test
    public void Test01(){
        String clzName="com.dcq.pojo.Student";
        try {
            Class clz = Class.forName(clzName);
            Object in = clz.newInstance();

            System.out.println(in+"这就是这个对象");


            List<Object> list = null;

            if (!(in instanceof Map)){
                Map<?,?> map = (Map) in;
                System.out.println("转成集合后为："+map);
            }else if (!list.contains(in)){
                list.add(in);
                System.out.println(list);
            }


        } catch (Exception e) {
            System.out.println(clzName+"这个类不存在");
            e.printStackTrace();
        }
    }
    @Test //将集合中的字段映射到实体类
    public void Test02() throws Exception {
        //将要赋值的对象 通过类名来生成
        Class<?> clz = Class.forName("com.dcq.pojo.Student");
        Object object = clz.newInstance();

        //自己模拟个jsonmap  来自hbase数据库
        Map<String,String> jsonMap = new HashMap(){{
            put("name","张三");
            put("age","age");
            put("address","中国");
            put("sex","男");
            put("phone","18877445464");

        }};
//        jsonMap.put("name","张三");
//        jsonMap.put("age","age");
//        jsonMap.put("address","中国");

        Field[] fields = object.getClass().getDeclaredFields();
        Method[] methods = object.getClass().getDeclaredMethods();

        //获取jsonmap的key集合
        Set<String> jsonSet = jsonMap.keySet();
        for (String memberVar : jsonSet) {

            String setMethodName = "set" +memberVar; //set方法，给 属性进行赋值
            String memberValue = null;
            //遍历地址创建对象的方法
            for (Method method : methods) {
                //如果由 系统创建的对象里面的方法等于set+属性 （如果由set方法就进行赋值）
                if (method.getName().equalsIgnoreCase(setMethodName)){
                    setMethodName = method.getName();  //确定下来方法名 setXXXX
                    if (memberVar == null){  //如果主键为null  hbase中的字段为空 跳出循环
                        continue;
                    }
                    // 系统创建类获取 set方法
                    Method setMethod = object.getClass().getMethod(setMethodName,memberVar.getClass());
                    memberValue = jsonMap.get(memberVar); //根据key去hbase集合中去获取字段
                    if (memberValue.equals(null)){
                        memberValue = null ; // 判断是否为null
                    }
                    //调用执行set方法   参数为对象、值
                    setMethod.invoke(object,memberValue);
                    break;
                }
            }
        }


        String s = JSON.toJSONString(object, new SerializeFilter[]{new ScNumberFilter()},SerializerFeature.WriteMapNullValue);
        System.out.println("s为"+s);

        System.out.println("赋值之后的为："+object);
        System.out.println("来自hbase的为"+jsonMap);
    }

    @Test
    public void Test03(){
        Map<String,Object> jsonMap = new HashMap<String,Object>(){{
            put("name","张三");
            put("age","age");
            put("address","中国");
        }};
    }

    @Test
    public void Test04(){
        Student student = new Student();

        String str1 = "{\"name\":\"张三\",\"age\":\"16\",\"address\":\"中国\",\"gz\":\"中国\"}";
        Student student1 = JSON.parseObject(str1, new TypeReference<Student>() {
        });
        System.out.println(student1);
    }

//    @Test
//    public Student Test05(){
////        StudentCopy studentCopy = new StudentCopy();
//
//        return studentCopy;
//    }

    @Test
    public void Test06(){
        Class<Student> studentClass = Student.class;
        Constructor<?>[] constructors = studentClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        StudentCopy studentCopy = new StudentCopy();
    }


    @Test
    public void Test99(){
      String current =null;
      String pageSize =null;
        if (current != null && pageSize!= null){
            int currentInt = Integer.parseInt(current);
            int pageSizeInt = Integer.parseInt(pageSize);
            System.out.println(currentInt+"----"+pageSizeInt);
        }
    }


}
