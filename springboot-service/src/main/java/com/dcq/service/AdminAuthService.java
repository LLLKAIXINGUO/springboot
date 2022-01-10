package com.dcq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dcq.entity.AdminAuth;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xty
 * @since 2022-01-07
 */
public interface AdminAuthService extends IService<AdminAuth> {

    List<AdminAuth> findAll(Integer pid);

}
