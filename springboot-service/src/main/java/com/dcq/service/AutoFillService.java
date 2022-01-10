package com.dcq.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dcq.entity.AutoFill;
import com.dcq.entity.dto.PageDTO;
import com.dcq.entity.vo.AutoFillVo;
import com.dcq.entity.vo.PageVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dcq
 * @since 2021-11-11
 */
public interface AutoFillService extends IService<AutoFill> {

    /**
     * 添加一条数据
     * @param autoFill
     * @return
     */
    int addOne(AutoFill autoFill);

    int update(AutoFill autoFill);

    List<AutoFill> findPage();

    List<AutoFill> findByName(String name);

    PageVo<List<AutoFillVo>> findPageTerm(PageDTO<Map<String,Object>> pageDTO) ;
}
