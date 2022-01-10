package com.dcq.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.dcq.pojo.Student;
import com.dcq.pojo.StudentCopy;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class ExcelWriteTest {

    final String PATH = "F:\\aa\\";

    @Test
    public void test01() throws IOException {
        //创建工作簿
        Workbook workbook = new HSSFWorkbook();
        //创建工作表
        Sheet sheet = workbook.createSheet("第一张表");

        /**
         *  -------------
         *  |--|--|--|--|
         *  -------------
         */
        //创建行
        Row row1 = sheet.createRow(0);// 从第一行开始
        //创建单元格
        Cell cell = row1.createCell(0);//第一个单元格
        //设置单元格数据
        cell.setCellValue("测试1");
        Cell cell2 = row1.createCell(1);//第二个单元格
        cell2.setCellValue(123456);

        //第二行
        Row row2 = sheet.createRow(1);// 从第二行开始
        Cell cell1 = row2.createCell(0);//第一个单元格
        cell1.setCellValue("测试2");

        Cell cell3 = row2.createCell(1);
        String time = new DateTime().toString("YYYY-MM-dd HH:mm:ss");
        cell3.setCellValue(time);

        //创建io流存放数据
        FileOutputStream fos = new FileOutputStream(PATH+"测试03.xls");
        //生成xls文件
        workbook.write(fos);
        //关闭流
        fos.close();
        System.out.println("生成完毕");
    }


    @Test
    public void test02() throws IOException {
        //创建工作簿
        Workbook workbook = new XSSFWorkbook();
        //创建工作表
        Sheet sheet = workbook.createSheet("第一张表");

        /**
         *  -------------
         *  |--|--|--|--|
         *  -------------
         */
        //创建行
        Row row1 = sheet.createRow(0);// 从第一行开始
        //创建单元格
        Cell cell = row1.createCell(0);//第一个单元格
        //设置单元格数据
        cell.setCellValue("测试1");
        Cell cell2 = row1.createCell(1);//第二个单元格
        cell2.setCellValue(123456);

        //第二行
        Row row2 = sheet.createRow(1);// 从第二行开始
        Cell cell1 = row2.createCell(0);//第一个单元格
        cell1.setCellValue("测试2");

        Cell cell3 = row2.createCell(1);
        String time = new DateTime().toString("YYYY-MM-dd HH:mm:ss");
        cell3.setCellValue(time);

        //创建io流存放数据
        FileOutputStream fos = new FileOutputStream(PATH+"测试07.xls");
        //生成xls文件
        workbook.write(fos);
        //关闭流
        fos.close();
        System.out.println("生成完毕");
    }

    @Test
    public void test03() throws IOException {
        //创建工作簿
        Workbook workbook = new SXSSFWorkbook();
        //创建工作表
        Sheet sheet = workbook.createSheet("大量数据");

        /**
         *  -------------
         *  |--|--|--|--|
         *  -------------
         */

        long start = System.currentTimeMillis();
        //外层循环65536行
        for (int i = 0; i < 100000; i++) {
            Row row = sheet.createRow(i);
            //内层循环每行10个单元格
            for (int j = 0; j <10; j++){
                Cell cell = row.createCell(j);
                cell.setCellValue("测试");
            }
        }

        //创建io流存放数据
        FileOutputStream fos = new FileOutputStream(PATH+"大数据测试07.xls");
        //生成xls文件
        workbook.write(fos);
        //关闭流
        fos.close();
        long end = System.currentTimeMillis();
        System.out.println("生成完毕总耗时："+ (end-start)+"毫秒");
    }

    @Test
    public void test04(){
//        Student student = new Student();
//        StudentCopy copy = new StudentCopy("张安",26);
//        BeanUtils.copyProperties(copy,student);
//
//        System.out.println(student);

    }


    @Test
    public void test05(){
        Student student = new Student();
        String str = "{\"name\":\"张三\",\"age\":\"16\",\"address\":\"中国\"}";

         student = JSON.parseObject(str, new TypeReference<Student>() {
        });
        System.out.println(student);

    }
}
