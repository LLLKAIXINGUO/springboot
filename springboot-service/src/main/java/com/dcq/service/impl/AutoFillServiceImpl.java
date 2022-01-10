package com.dcq.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dcq.entity.AutoFill;
import com.dcq.entity.dto.PageDTO;
import com.dcq.entity.vo.AutoFillVo;
import com.dcq.entity.vo.PageVo;
import com.dcq.mapper.AutoFillMapper;
import com.dcq.service.AutoFillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dcq
 * @since 2021-11-11
 */
@Service
public class AutoFillServiceImpl extends ServiceImpl<AutoFillMapper, AutoFill> implements AutoFillService {

    @Autowired
    AutoFillMapper autoFillMapper;

    @Override
    public int addOne(AutoFill autoFill) {
        //第一步处理数据，实现自动填充功能

        //第二步调用mapper接口进行添加的操作
        System.out.println("没有调用dao之前"+autoFill);

        int i = autoFillMapper.addOne(autoFill);
        //第三步返回处理的结果
        System.out.println("调用dao之后"+autoFill);

        return i;
    }

    @Override
    public int update(AutoFill autoFill) {
        int i = autoFillMapper.updateOne(autoFill);
        return i;
    }



    @Override
    public List<AutoFill> findPage() {
        IPage<AutoFill> page = new Page<>();
//        this.total = 0L;
//        this.size = 10L;
//        this.current = 1L;
        page.setCurrent(1); //从第二页开始
        page.setSize(5); //每页显示5条

        IPage<AutoFill> autoFillPage = autoFillMapper.selectPage(page,new QueryWrapper<>());
        List<AutoFill> records = autoFillPage.getRecords();
        return records;
    }

    @Override
    public List<AutoFill> findByName(String name) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("name","%"+name+"%");

        List list = autoFillMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public PageVo<List<AutoFillVo>> findPageTerm(PageDTO<Map<String,Object>> pageDTO) {
        //判断是否为空
        if (pageDTO == null) {
//           throw  new IllegalArgumentException("")
            return  new PageVo<List<AutoFillVo>>();
        }
        //开启分页
        Page page = new Page(pageDTO.getPage(),pageDTO.getSize());

        //条件查询
        Map<String, Object> mapWhere = pageDTO.getWhere();
        //调用mapper层
        List<AutoFillVo> autoFillVoList = autoFillMapper.findPage(page, mapWhere);

        //查询完之后封装成pagevo
        PageVo pageVo = new PageVo();
        pageVo.setContent(autoFillVoList);
        return pageVo;
    }


}
