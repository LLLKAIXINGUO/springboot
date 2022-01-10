package com.dcq.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageVo<T> {

    //当前页
    private Integer current;

    //每页条数pageSize
    private Integer pageSize;

    //数据
    private List<T> content;

    public PageVo(Integer current, Integer pageSize) {
        this.current = current;
        this.pageSize = pageSize;
    }

    public PageVo() {

    }

    public PageVo(Integer current, Integer pageSize, List<T> content) {
        this.current = current;
        this.pageSize = pageSize;
        this.content = content;
    }
}
