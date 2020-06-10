package com.example.campus.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.campus.entity.Result;
import com.example.campus.entity.User;
import com.example.campus.service.UserService;
import com.example.campus.utils.CreateTestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            createTestData.createDataOfPost();
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
    public String addUser(HttpServletRequest request, HttpServletResponse response){
        JSONObject userJson = JSONObject.parseObject(request.getParameter("user"));
        User user = new User();
        user.setUserno(userJson.getString("userNo"));
        user.setIsresgister(1);
        user.setAddress(userJson.getString(""));
        user.setEmail(userJson.getString(""));
        user.setUserrealname(userJson.getString(""));
        user.setPassword(userJson.getString(""));
        user.setInstitute(userJson.getString(""));
        Map<String ,Object> map=new HashMap<>();
        map.put("data",userService.insertUser(user));
        map.put("api","addUser");
        return JSONObject.toJSONString(new Result(map,"200","添加用户成功"));
    }

    @PostMapping("userInfo")
    public String selUserInfo(String userno){
        return JSON.toJSONString(userService.selUserInfo(userno));
    }

    @GetMapping("getAllClass")
    public String getAllClass(){
                return JSON.toJSONString(userService.getAllClass());
    }

    /**
     * 查找已收藏的商品
     * @param userId
     * @return
     */
    @GetMapping("getColletionByUserId")
    public String getColletionByUserId(String userId){
        Map<String ,Object> map=new HashMap<>();
        map.put("colletion",userService.getColletionByUserId(userId));
        return JSONObject.toJSONString(new Result(map,"200","success"));
    }

    /**
     * 收藏商品
     * @param userId
     * @param productId
     * @return
     */
    @PostMapping("setColletion")
    public String setColletion(String userId,String productId){
        if(1==userService.setColletion(userId,productId)){
            return JSONObject.toJSONString(new Result("200","success"));
        }else{
            return JSONObject.toJSONString(new Result("201","falure"));
        }
    }


}
