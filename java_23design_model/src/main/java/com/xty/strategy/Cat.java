package com.xty.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat implements Comparable<Cat> {

    private Integer weight;

    private Integer height;


    @Override
    public int compareTo(Cat c) {


        if (this.weight > c.weight){
            return 1;
        }else if (this.weight < c.weight){
            return -1;
        }else {
            return 0;
        }
    }


}
