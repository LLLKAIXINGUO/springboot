package com.dcq.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.dcq.entity.StudentInfo;

import java.util.List;
import java.util.Map;

public interface StudentInfoService extends IService<StudentInfo> {

    List<StudentInfo> findAll();

    List<StudentInfo> findOne(String name);

    int save2(Map<String,Object>map);

}
