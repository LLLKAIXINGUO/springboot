package com.dcq.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private Integer pid;
    private String name;
    private Integer age;
    private List<StudentInfo> studentList;
}
