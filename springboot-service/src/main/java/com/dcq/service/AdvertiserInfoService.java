package com.dcq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dcq.common.Pagination;
import com.dcq.entity.AdvertiserInfo;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * <p>
 * 公告信息表 服务类
 * </p>
 *
 * @author xty
 * @since 2021-12-28
 */
public interface AdvertiserInfoService extends IService<AdvertiserInfo> {

    Pagination<AdvertiserInfo> findPage(Map<String, Object> params);

    /**
     * 导出
     * @param outputStream
     */
    void exportData(OutputStream outputStream);

    void importData(InputStream inputStream);
}
