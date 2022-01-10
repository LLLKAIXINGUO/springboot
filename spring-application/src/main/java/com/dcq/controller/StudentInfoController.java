package com.dcq.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dcq.entity.StudentInfo;
import com.dcq.service.StudentInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentInfoController {

    @Autowired
    private StudentInfoService studentService;

    //实现查询student集合的时候先去redis中查询
    @RequestMapping("findAll")
    public List<StudentInfo> findAll() {
        List<StudentInfo> all = this.studentService.findAll();
        return all;
    }

    @GetMapping("/selectAll")
    public List<StudentInfo> selectAll() {

        return studentService.list(new QueryWrapper<StudentInfo>());

    }

    @RequestMapping("findOne")
    public List<StudentInfo> findOne(String name) {
        List<StudentInfo> students = studentService.findOne(name);
        return students;
    }

    @PostMapping("add")
    public int add(@RequestBody StudentInfo student) {
        boolean result = studentService.save(student);
        return result?1:0;
    }

    @PostMapping("addMap")
    public int addMap(@RequestBody Map<String, Object> map) {
        int i = studentService.save2(map);
        return i;
    }

    //修改接口
    @PutMapping("update")
    public int update(@RequestBody StudentInfo student) {
        boolean i = studentService.update(student,null);
        return i?1:0;
    }

    @RequestMapping("test001")
    public List<StudentInfo> test(@RequestParam("aaaname") String name,String age) {
        System.out.println(age);
        return studentService.findOne(name);
    }


}

