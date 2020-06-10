package com.example.campus.service.impl;

import com.example.campus.entity.Message;
import com.example.campus.mapper.MessageMapper;
import com.example.campus.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Override
    public int creatMsg(String content,String AcceptClass) {
        messageMapper.creatMsg(content,new java.sql.Timestamp(System.currentTimeMillis()),AcceptClass);
        return 1;
    }
    @Override
    public HashMap<String,Object> getAllMsg(String searchInfo, Integer pageNum, Integer pageSize) {
        List<List<Message>> list = messageMapper.getAllMsg(searchInfo,(pageNum - 1) * pageSize,pageSize);
        List<Message> list1=new ArrayList<>();
        HashMap<String,Object> data=new HashMap<>();
        list.get(0).forEach(
                e->{
                    //list1.add(e);
                    Collections.addAll(list1,e);
                }
        );
        data.put("msgList",list1);
        data.put("total",list.get(1).get(0));
        return data;
    }

    @Override
    public List<Message> getMessageByUserId(String userId) {
        return messageMapper.selMessageByUserId(userId);
    }
}
