package com.dcq.utils;

import com.alibaba.excel.EasyExcel;
import com.dcq.common.DataEasyExcelListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author chengzhuang
 * @description: excel导出导入工具类
 * @date 2020/10/1316:10
 */
@Component
public class ExcelUtils<T> {

    public static <T> List<T> importFile(InputStream inputStream, int sheetNo, Class<T> clazz) throws IOException {
        DataEasyExcelListener<T> listener = new DataEasyExcelListener<>();
        EasyExcel.read(inputStream, clazz, listener).sheet(sheetNo).doRead();
        List<T> data = listener.getData();
        return data;
    }
}