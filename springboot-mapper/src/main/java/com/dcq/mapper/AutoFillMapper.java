package com.dcq.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectPage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dcq.entity.AutoFill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dcq.entity.vo.AutoFillVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dcq
 * @since 2021-11-11
 */
public interface AutoFillMapper extends BaseMapper<AutoFill> {

    //要求更新操作的时候记录下人、时间
    //插入操作

    int addOne(AutoFill autoFill);

    //修改操作
    int updateOne(AutoFill autoFill);

    //查询操作
    List<AutoFillVo> findPage(IPage<AutoFillVo> iPage, Map<String,Object> map);

    @Select("select * from auto_fill")
    List<HashMap<String,Object>> findMap();
}
