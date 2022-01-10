package com.xty.java8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 交易类
public class Transaction {

    private Trader trader;
    private Integer year;
    private Integer value;

}
