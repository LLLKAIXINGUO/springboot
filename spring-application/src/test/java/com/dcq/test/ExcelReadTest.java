package com.dcq.test;

import org.apache.ibatis.annotations.Case;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReadTest {

    final String PATH = "F:\\aa\\";

    @Test
    public void test01() throws IOException {

        FileInputStream fis = new FileInputStream(PATH+"测试03.xls");
        //创建工作簿 导入excel表
        Workbook workbook = new HSSFWorkbook(fis);

        //读取sheet表
        Sheet sheet = workbook.getSheetAt(0);//根据下标去获取表

        //读取行
        Row row = sheet.getRow(1);

        //读取单元格
        Cell cell = row.getCell(0);

        //读取值的时候注意类型 字符型使用string...val  数字型用number...val
        //读取内容
        String value = cell.getStringCellValue();

        System.out.println(value);

        //关闭io流
        fis.close();
    }

    @Test
    public void test02() throws IOException {

        FileInputStream fis = new FileInputStream(PATH+"学生成绩.xlsx");
        //创建工作簿 导入excel表
        Workbook workbook = new XSSFWorkbook(fis);

        //读取sheet表
        Sheet sheet = workbook.getSheetAt(0);//根据下标去获取表

        //获取标题信息
        Row rowTable = sheet.getRow(0);
        if (rowTable != null){
            //获取到当前行的所有单元格数量
            int cellCount = rowTable.getPhysicalNumberOfCells();
            for (int i = 0; i < cellCount; i++) {
                Cell cell = rowTable.getCell(i);
                if (cell != null){
                    //获取到单元格信息
                    int cellType1 = cell.getCellType();
//                    CellType cellType = cell.getCellType();
                    String value = cell.getStringCellValue();
                    System.out.print(value+ "|");
                }
            }
            System.out.println();
        }

        //获取所有行
        int rowCount = sheet.getPhysicalNumberOfRows();
        //遍历行
        for (int rowNum = 1; rowNum < rowCount; rowNum++) {
            Row rowData = sheet.getRow(rowNum);//通过 表对象.行对象确定第几行，
            if (rowData != null){
                //获取行中的所有列
                int cellCount = rowData.getPhysicalNumberOfCells();
                //遍历列
                for (int cellNum = 0; cellNum < cellCount; cellNum++) {
                    Cell cellData = rowData.getCell(cellNum);
                    if (cellData != null){
                        //如果单元格不为空 输出内容
//                        CellType cellType = cellData.getCellType();//获取单元格的类型
                        //匹配数据类型
//                        switch (cellType){

//                        }
                    }
                }
            }
        }
        
        //关闭io流
        fis.close();
    }
}
