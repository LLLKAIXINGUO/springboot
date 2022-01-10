package com.dcq.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class AUUUFill {


    //当你开启了主键自增长，需要设置主键的type为IdType.AUTO
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    /**
     * 年龄0为男 1为女
     */
    @TableField("age")
    private Integer age;

    /**
     * 逻辑删除   0为删除，1为没删
     */
    @TableField("is_delete")
    private Integer isDelete;

    /**
     * 创建人  来自于自动填充，如果没有system
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 编辑人  自动填充，如果没有为system
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 创建数据的时间
     */
    @TableField(value = "create_time",fill = FieldFill.INSERT ) //插入的时候自动填充
    private Date createTime;

    /**
     * 数据修改时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE) //插入和修改的时候自动填充
    private Date updateTime;
}
