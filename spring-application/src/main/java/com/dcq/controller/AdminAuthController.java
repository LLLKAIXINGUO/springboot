package com.dcq.controller;


import com.dcq.common.R;
import com.dcq.entity.AdminAuth;
import com.dcq.service.AdminAuthService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xty
 * @since 2022-01-07
 */
@RestController
@RequestMapping("/admin/auth")
public class AdminAuthController {

    @Autowired
    private AdminAuthService adminAuthService;

    @GetMapping("/findList/{pid}")
    @ApiOperation("查询所有的权限")
    public R<List<AdminAuth>> findAll(@PathVariable("pid") Integer pid) {
         List<AdminAuth> adminAuths = adminAuthService.findAll(pid);

        return R.success(adminAuths);
    }

}

