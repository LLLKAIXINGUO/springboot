package com.dcq.test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.dcq.pojo.DemoData;
import com.dcq.pojo.DemoDataListener;
import org.junit.Test;

import java.io.File;

public class EasyReadTest {

    final String PATH = "F:\\aa\\";

    @Test
    public void test01(){
        String fileName = PATH + "easy测试.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData .class, new DemoDataListener()).sheet().doRead();

    }

}
