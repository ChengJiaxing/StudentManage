package com.example.studentmanager.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.studentmanager.mapper.StudentMapper;
import com.example.studentmanager.mapper.UserMapper;
import com.example.studentmanager.model.Student;
import com.example.studentmanager.model.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
@CrossOrigin(origins = {"*", "null"})
@RestController
public class Controller {
    private static Gson gson = new Gson();
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/students")
    public String showStudent() {
        List<Student> students = studentMapper.selectList(null);
        return gson.toJson(students);
    }

    @PostMapping("/delete")
    public void deleteStudent(@RequestBody Student student) {
        studentMapper.deleteById(student);
    }

    @PostMapping("/add")
    public void insertStudent(@RequestBody Student student) {
        studentMapper.insert(student);
    }

    @PostMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        studentMapper.updateById(student);
    }

    @PostMapping("/login")
    public String loginStudent(@RequestBody User user) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.setEntity(user);
        userMapper.selectOne(userQueryWrapper);
        User user_selected = userMapper.selectOne(userQueryWrapper);
        if (user_selected == null) {
            return "0";
        }
        return "1";
    }
    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        userMapper.insert(user);
    }

    @PostMapping("/search")
    public String search(@RequestBody HashMap<String,String> data){
        String name=data.get("name");
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.like("name",name);
        List<Student> students = studentMapper.selectList(studentQueryWrapper);
        return gson.toJson(students);
    }
}
