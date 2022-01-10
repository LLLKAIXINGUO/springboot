package com.dcq.service.impl;

import cn.hutool.json.JSONUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dcq.entity.StudentInfo;
import com.dcq.mapper.StudentInfoMapper;
import com.dcq.redis.RedisUtils;
import com.dcq.service.StudentInfoService;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper, StudentInfo> implements StudentInfoService {

    @Autowired
    private StudentInfoMapper studentMapper;

    @Autowired
    RedisUtils redisUtils;

    @Override
    public List<StudentInfo> findAll() {
        //先从redis中去获取
        Object obj = redisUtils.get("spring:student");
        if (StringUtils.isEmpty(obj)){
            //去数据库查
            List<StudentInfo> studentList = studentMapper.getAll();
            String json = JSONUtil.parse(studentList).toStringPretty();
            //存入到redis中
            redisUtils.set("spring:student",json);
            return studentList;
        }else {
            String students = String.valueOf(obj);
            List list = JSONUtil.toList(students, StudentInfo.class);
            return list;
        }

    }

    @Override
    public List<StudentInfo> findOne(String name) {
        List<StudentInfo> one = studentMapper.getOne(name);
        System.out.println(one);
        return one;
    }


    @Override
    public int save2(Map<String, Object> map) {
        int i = studentMapper.save2(map);
        return i;
    }

}
