package com.dcq.entity.dto;

import lombok.Data;

@Data
public class PageDTO<T> {

    //("当前页")
    private  Integer page = 2;
    //("每页显示条数")
    private  Integer size = 3;

    //("查询条件")
    private T where;
}