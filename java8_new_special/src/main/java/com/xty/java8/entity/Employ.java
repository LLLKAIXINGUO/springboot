package com.xty.java8.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employ {

    private String name;
    @NonNull
    private Integer age;
    @NonNull
    private Double salary;

    private Status status;

    public Employ(@NonNull Integer age) {
        this.age = age;
    }

    public enum Status{
        FREE,
        BUSY,
        VOCATION;
    }
}
