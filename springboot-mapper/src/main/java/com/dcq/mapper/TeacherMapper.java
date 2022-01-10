package com.dcq.mapper;

import com.dcq.entity.StudentInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    /**
     * 根据老师的编号查询到旗下所有的学生
     * @param pid  老师编号
     * @return
     */
    @Select("select * from student_info s where s.pid = #{pid}")
    List<StudentInfo> findAllStudent(int pid);
}
