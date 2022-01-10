package com.dcq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dcq.entity.AdminAuth;
import com.dcq.mapper.AdminAuthMapper;
import com.dcq.service.AdminAuthService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xty
 * @since 2022-01-07
 */
@Service
public class AdminAuthServiceImpl extends ServiceImpl<AdminAuthMapper, AdminAuth> implements AdminAuthService {

    @Override
    public List<AdminAuth> findAll(Integer pid) {

        // 查询父级菜单下的子级菜单
        List<AdminAuth> adminAuths = this.baseMapper.selectChildrenList(pid);

        adminAuths = findChildrenAuth(adminAuths);

        return adminAuths;
    }

    /**
     * 查询子菜单
     * @param adminAuths
     * @return
     */
    public List<AdminAuth> findChildrenAuth(List<AdminAuth> adminAuths){
        List<AdminAuth> childrenAdminAuths = new ArrayList<>();
        for (AdminAuth adminAuth : adminAuths) {
            // 先判断还有没有子菜单,有把它查出来。继续查子菜单下的子菜单。直到子菜单没有子菜单为止在设置值
            if (this.baseMapper.selectCount(adminAuth.getAuthId()) > 0){
                childrenAdminAuths = this.baseMapper.selectChildrenList(adminAuth.getAuthId());
                findChildrenAuth(childrenAdminAuths);
                adminAuth.setList(childrenAdminAuths);
            }
        }
       return adminAuths;
    }
}
