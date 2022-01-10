package com.dcq.pojo;

import com.dcq.entity.StudentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCopy extends StudentInfo {
    private String name;
    private Integer age;


}
