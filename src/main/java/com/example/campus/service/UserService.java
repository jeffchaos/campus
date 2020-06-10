package com.example.campus.service;


import com.example.campus.entity.User;
import com.example.campus.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public int insert(User record) {
        return 0;
    }


    public int insertSelective(User record) {
        return 0;
    }


    public List<User> getAllUsers() {
        //UserExample userExample = new UserExample();
        return userMapper.getAllUsers();
    }
    public int insertUser(User user){
        return userMapper.insert(user);
    }

    public User selectUserByUserNo(Map<String,String> map){
        return userMapper.selectUserByUserNo(map);
    }

    public List<String> getAllClass(){
        return userMapper.getAllClass();
    }
}
