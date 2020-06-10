package com.example.campus.service;

import com.example.campus.entity.Message;

import java.util.HashMap;
import java.util.List;

public interface MessageService {


    int creatMsg(String content,String AcceptClass);
    HashMap<String,Object> getAllMsg(String searchInfo, Integer pageNum, Integer pageSize);

    List<Message> getMessageByUserId(int userId);
}
