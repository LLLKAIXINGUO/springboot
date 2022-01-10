package com.dcq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Student {
    private String name;
    private String age;
    private String address;
    private String score;
    private String clound_kh;
    public String testName;

    public Student(String name, String age, String address, String score, String clound_kh, String testName) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.score = score;
        this.clound_kh = clound_kh;
        this.testName = testName;
    }

    public Student(String name, String age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student() {
    }

    private Student(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
