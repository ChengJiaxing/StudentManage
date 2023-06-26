package com.example.studentmanager.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.studentmanager.model.User;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
