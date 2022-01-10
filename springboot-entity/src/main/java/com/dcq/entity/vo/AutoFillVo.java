package com.dcq.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.dcq.entity.AutoGill;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AutoFillVo {

    private Integer id;

    private String name;

    /**
     * 年龄0为男 1为女
     */
    private Integer age;

    /**
     * 逻辑删除   0为删除，1为没删
     */
    private Integer isDelete;

    /**
     * 创建人  来自于自动填充，如果没有system
     */
    private String createBy;

    /**
     * 编辑人  自动填充，如果没有为system
     */
    private String updateBy;

    /**
     * 创建数据的时间
     */
    private Date createTime;

    /**
     * 数据修改时间
     */
    private Date updateTime;

    private List<AutoGill> autoGillList;
}
