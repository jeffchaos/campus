package com.example.campus.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class HttprequestApi {
    /// 验证账号是否重复
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取传递过来的user信息
        String data = request.getParameter("data");
        Type type = new TypeToken<Map>(){}.getType();
        Map<String,String> user= new Gson().fromJson(data, type);
        //验证user是否正确
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username","asfwaf");
        map.put("password","124312412");
        //回传验证信息
        Gson gson=new Gson();
        String jsonstr=gson.toJson(map);
        System.out.println(data);
        PrintWriter out = response.getWriter();
        out.write(jsonstr);
        out.flush();
        out.close();

    }
    /// 验证账号是否重复
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取传递过来的user信息
        String data = request.getParameter("data");
        Type type = new TypeToken<Map>(){}.getType();
        Map<String,String> user= new Gson().fromJson(data, type);
        //验证user是否正确
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username","asfwaf");
        map.put("password","124312412");
        //回传验证信息
        Gson gson=new Gson();
        String jsonstr=gson.toJson(map);
        System.out.println(data);
        PrintWriter out = response.getWriter();
        out.write(jsonstr);
        out.flush();
        out.close();

    }
}
