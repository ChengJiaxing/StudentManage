package com.example.studentmanager.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.studentmanager.model.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}
