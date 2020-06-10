package com.example.campus.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.campus.entity.Result;
import com.example.campus.service.CommentService;
import com.sun.org.apache.xml.internal.security.Init;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("getAllComment")
    public String getAllComment(String searchInfo,@RequestParam(value = "page") Integer pageNum,
                                @RequestParam(value = "limit") Integer pageSize
                                ){
        String result= JSON.toJSONStringWithDateFormat(
                new Result(
                        commentService.getAllComment(searchInfo,pageNum,pageSize)
                        ,"0"
                        ,"获取所有评论信息成功")
                ,"yyyy-MM-dd hh:mm:ss"
                , SerializerFeature.WriteNonStringValueAsString);
        return result;
    }
    @PostMapping("delComments")
    public String delComments(String ids, String msg){
        //System.out.println(ids+" ; "+ ids.getClass().getName().toString());
        System.out.println(ids);
        List<String> list= Arrays.asList(ids.split(","));

        commentService.delComments(list);
        String result= JSON.toJSONStringWithDateFormat(
                new Result(
                        "200"
                        ,"批量删除评论成功")
                ,"yyyy-MM-dd hh:mm:ss"
                , SerializerFeature.WriteNonStringValueAsString);
        return result;
    }
    @PostMapping("deleteByPrimaryKey")
    public String deleteByPrimaryKey(int id,String msg){
        commentService.deleteByPrimaryKey(id);
        String result= JSON.toJSONStringWithDateFormat(
                new Result(
                        "200"
                        ,"删除评论成功")
                ,"yyyy-MM-dd hh:mm:ss"
                , SerializerFeature.WriteNonStringValueAsString);
        return result;
    }
}
