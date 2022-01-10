package com.dcq.controller;



import com.dcq.common.Pagination;
import com.dcq.common.R;
import com.dcq.entity.AdvertiserInfo;
import com.dcq.service.AdvertiserInfoService;
import com.dcq.utils.DownloadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

/**
 * <p>
 * 公告信息表 前端控制器
 * </p>
 *
 * @author xty
 * @since 2021-12-28
 */
@RestController
@RequestMapping("/advertiser/info")
@Api(tags = "公告信息模块")
public class AdvertiserInfoController {

    @Autowired
    private AdvertiserInfoService advertiserInfoService;

    @GetMapping("/findPage")
    @ApiOperation("分页查询")
    public R<Pagination<AdvertiserInfo>> findPage(@RequestParam Map<String, Object> params) {
        return R.success(advertiserInfoService.findPage(params));
    }


    @GetMapping("/exportData")
    @ApiOperation("导出")
    public void exportData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 判断浏览器的类型:
        String agent = request.getHeader("User-Agent");
        String fileName = "公告信息.xls";
        if (agent.contains("Firefox")) {
            // 使用的是Firefox
            fileName = DownloadUtil.base64EncodeFileName(fileName);
        } else {
            // IE或者其他的浏览器
            fileName = URLEncoder.encode(fileName, "UTF-8");
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/x-download");
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        response.addHeader("Access-Control-Expose-Headers", "Content-Disposition");
        OutputStream outputStream = response.getOutputStream();
        advertiserInfoService.exportData(outputStream);
        response.flushBuffer();
    }

    @PostMapping("/importData")
    @ApiOperation("导入")
    public R importData(@RequestParam MultipartFile file) throws IOException {
        if(file.isEmpty()) {
            return R.error("文件为空");
        }
        advertiserInfoService.importData(file.getInputStream());
        return R.success("上传成功");
    }

    @PostMapping("/save")
    @ApiOperation("保存")
    public R save(@RequestBody @Valid AdvertiserInfo advertiserInfo) {
        if (advertiserInfoService.save(advertiserInfo)) {
            return R.success("保存成功");
        } else {
            return R.error("保存失败");
        }
    }

    @PutMapping("/update")
    @ApiOperation("修改")
    public R update(@RequestBody @Valid AdvertiserInfo advertiserInfo) {
        if (advertiserInfoService.updateById(advertiserInfo)) {
            return R.success("修改成功");
        } else {
            return R.error("修改失败");
        }
    }

    @GetMapping("/findOne/{id}")
    @ApiOperation("查询公告信息详情")
    public R<AdvertiserInfo> findOne(@PathVariable("id") Long id) {
        return R.success(advertiserInfoService.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    public R update(@PathVariable("id") Long id) {
        if (advertiserInfoService.removeById(id)) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");
        }
    }

}

