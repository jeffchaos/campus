package com.example.campus.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.campus.entity.Result;
import com.example.campus.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @PostMapping("creatMsg")
    public String creatMsg(String content,String AcceptClass){
        messageService.creatMsg( content, AcceptClass);
        String result= JSON.toJSONStringWithDateFormat(
                new Result(
                        "200"
                        ,"发送信息成功")
                ,"yyyy-MM-dd hh:mm:ss"
                , SerializerFeature.WriteNonStringValueAsString);
        return result;
    }
    @GetMapping("getAllMsg")
    public String getAllMsg(String searchInfo,@RequestParam(value = "page") Integer pageNum,
                            @RequestParam(value = "limit") Integer pageSize){
        String result= JSON.toJSONStringWithDateFormat(
                new Result( messageService.getAllMsg(searchInfo, pageNum, pageSize)
                        ,"0"
                        ,"查询所有消息成功")
                ,"yyyy-MM-dd hh:mm:ss"
                , SerializerFeature.WriteNonStringValueAsString);
        return result;
    }

    /**
     * 查看消息
     * @param userId
     * @return
     */
    @GetMapping("selMessageByUserId")
    public String selMessageByUserId(Integer userId){
        Map<String ,Object> map=new HashMap<>();
        map.put("message",messageService.getMessageByUserId(userId));
        return JSONObject.toJSONString(new Result(map,"200","获取消息成功"));
    }
}
