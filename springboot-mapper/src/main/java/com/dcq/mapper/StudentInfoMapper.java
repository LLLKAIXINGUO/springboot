package com.dcq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dcq.entity.StudentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentInfoMapper extends BaseMapper<StudentInfo> {

    @Select("select * from student_info")
    List<StudentInfo> getAll();

    //加上@Param注解就可以直接通过别名的形式去获取
    List<StudentInfo> getOne(@Param("name") String name);

    //添加(使用map来接受)
    int save2(Map<String,Object> map);

}
