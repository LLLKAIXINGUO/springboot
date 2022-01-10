package com.dcq.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dcq.entity.AutoFill;
import com.dcq.entity.dto.PageDTO;
import com.dcq.entity.vo.AutoFillVo;
import com.dcq.entity.vo.PageVo;
import com.dcq.mapper.AutoFillMapper;
import com.dcq.service.AutoFillService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dcq
 * @since 2021-11-11
 */
@RestController
@RequestMapping("/autofill")
public class AutoFillController {

    @Autowired
    AutoFillService autoFillService;

    @RequestMapping("add")
    public String add(@RequestBody AutoFill autoFill){
//        AutoFill autoFill = new AutoFill();
//        autoFill.setAge(18);
//        autoFill.setName("林青霞");
        //剩余的逻辑删除、创建人、修改人、创建时间、修改时间都是由系统自动生成的

        int i = autoFillService.addOne(autoFill);
        if (i > 0){
            return "添加成功，添加了"+i+"条数据";
        }else {
            return "添加失败，请检查参数是否有误";
        }
    }

    @RequestMapping("update")
    public String update(@RequestBody AutoFill autoFill){
        //剩余的逻辑删除、创建人、修改人、创建时间、修改时间都是由系统自动生成的
        int i = autoFillService.update(autoFill);
        if (i > 0){
            return "修改成功，修改了"+i+"条数据";
        }else {
            return "修改失败，请检查参数是否有误";
        }
    }

    @RequestMapping("findAll")
    public List<AutoFill> findAll(){

        List<AutoFill> page = autoFillService.findPage();
        return page;
    }

    //根据传入的名称，service层使用Mybatis—plus 的eq方法来进行判断然后进行返回
    @RequestMapping("findByName")
    public List<AutoFill> findByName(@RequestParam("name") String name){
        List<AutoFill> byName = autoFillService.findByName(name);
        return byName;
    }

    @RequestMapping("findPage")
    public PageVo<List<AutoFillVo>> findPage(@RequestBody PageDTO<Map<String,Object>> pageDTO){

        //将封装的pageDTO传入Server层 疯转的里面有默认的当前页和每页条数，如果要修改的话在server层进行赋值
        PageVo<List<AutoFillVo>> pageVo = autoFillService.findPageTerm(pageDTO);
        return pageVo;
    }


    @Autowired
    AutoFillMapper autoFillMapper;
    @RequestMapping("findMap")
    public List findMap(){

        return autoFillMapper.findMap();
    }
}
