package com.dcq.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dcq.annotation.TestLog;
import com.dcq.common.PageBuilder;
import com.dcq.common.Pagination;
import com.dcq.entity.AdvertiserInfo;
import com.dcq.mapper.AdvertiserInfoMapper;
import com.dcq.service.AdvertiserInfoService;
import com.dcq.utils.ExcelUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 公告信息表 服务实现类
 * </p>
 *
 * @author xty
 * @since 2021-12-28
 */
@Service
public class AdvertiserInfoServiceImpl extends ServiceImpl<AdvertiserInfoMapper, AdvertiserInfo> implements AdvertiserInfoService {

    @Override
    @TestLog("1")
    public Pagination<AdvertiserInfo> findPage(Map<String, Object> params) {
        String name = (String) params.get("name");
        String content = (String) params.get("content");
        String time = (String) params.get("time");

        IPage<AdvertiserInfo> page = this.page(new PageBuilder<AdvertiserInfo>(params).build(),
                new LambdaQueryWrapper<AdvertiserInfo>()
                        .eq(StringUtils.isNotBlank(name),AdvertiserInfo::getName,name)
                        .like(StringUtils.isNotBlank(content),AdvertiserInfo::getName,content)
                        .orderByAsc(AdvertiserInfo::getTime));
        return new Pagination<>(page);
    }


    @Override
    public void exportData(OutputStream outputStream) {

        ExcelWriter excelWriter = EasyExcel.write(outputStream).build();
        //第一个sheet
        WriteSheet writeSheet = EasyExcel.writerSheet(0).head(AdvertiserInfo.class).build();
        excelWriter.write(this.list(), writeSheet);
        excelWriter.finish();

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void importData(InputStream inputStream) {
        try {
            List<AdvertiserInfo> advertiserInfos = ExcelUtils.importFile(inputStream, 0, AdvertiserInfo.class);
            for (AdvertiserInfo advertiserInfo : advertiserInfos) {
                this.save(advertiserInfo);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
