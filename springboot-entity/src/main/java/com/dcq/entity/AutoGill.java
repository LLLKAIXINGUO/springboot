package com.dcq.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("auto_gill")
public class AutoGill {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("aname")
    private String aname;


    @TableField("aid")
    private Integer aid;
}
