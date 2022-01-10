package com.dcq.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.dcq.entity.converter.NameConverter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 公告信息表
 * </p>
 *
 * @author xty
 * @since 2021-12-28
 */
@Data
@ApiModel(value="AdvertiserInfo对象", description="公告信息表")
public class AdvertiserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    @ExcelIgnore
    private Long id;

    // converter 属性 是对这个字段进行特殊处理
    @ApiModelProperty(value = "公告名称")
    @NotNull(message = "公告名称不能为空")
    @ExcelProperty(value = "公告名称" , converter = NameConverter.class)
    private String name;

    @ApiModelProperty(value = "公告内容")
    @ExcelProperty(value = "公告内容")
    private String content;

    @ApiModelProperty(value = "公告时间")
    @ExcelProperty(value = "公告时间")
    private String time;


}
