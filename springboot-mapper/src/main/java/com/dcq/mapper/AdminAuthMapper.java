package com.dcq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dcq.entity.AdminAuth;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xty
 * @since 2022-01-07
 */
public interface AdminAuthMapper extends BaseMapper<AdminAuth> {

    /*
        查询该菜单下所有子菜单
     */
    @Select(" select * from admin_auth where auth_pid = #{id} ")
    List<AdminAuth> selectChildrenList(Integer id);

    /*
        统计子菜单个数
     */
    @Select(" select count(*) from admin_auth where auth_pid = #{id} ")
    Long selectCount(Integer id);
}
