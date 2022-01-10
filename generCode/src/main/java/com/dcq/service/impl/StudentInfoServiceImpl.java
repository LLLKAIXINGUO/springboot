package com.dcq.service.impl;

import com.dcq.entity.StudentInfo;
import com.dcq.mapper.StudentInfoMapper;
import com.dcq.service.StudentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生信息表 服务实现类
 * </p>
 *
 * @author xty
 * @since 2021-12-27
 */
@Service
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper, StudentInfo> implements StudentInfoService {

}
