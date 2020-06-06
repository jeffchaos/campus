package com.example.campus.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.campus.entity.User;
import com.example.campus.service.UserService;
import com.example.campus.utils.CreateTestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    CreateTestData createTestData;
    
    @RequestMapping("/getUsers")
    public List<User> getDbType() {
        //CreateTestData createTestData = new CreateTestData();
        createTestData.createDataOfProduct();
        System.out.println("到了");
        return userService.getAllUsers();
    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Map<String,User> loginWithUserNo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userNo = request.getParameter("userNo");
        Map<String,String> map1 = new HashMap<>();
        map1.put("userno",userNo);
        User user = userService.selectUserByUserNo(map1);
        Map<String,User> map = new HashMap<>();
        if(user != null){
            map.put("success",user);
        }
        else{ map.put("failed",null);}
        return map;


    }


    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public int addUser(HttpServletRequest request, HttpServletResponse response){
        JSONObject userJson = JSONObject.parseObject(request.getParameter("user"));
        User user = new User();
        user.setUserno(userJson.getString("userNo"));
        user.setIsresgister(1);
        user.setAddress(userJson.getString(""));
        user.setEmail(userJson.getString(""));
        user.setUserrealname(userJson.getString(""));
        user.setPassword(userJson.getString(""));
        user.setInstitute(userJson.getString(""));
        return userService.insertUser(user);
    }
}
