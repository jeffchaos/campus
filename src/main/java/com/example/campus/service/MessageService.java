package com.example.campus.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.security.Timestamp;
import java.util.HashMap;
import java.util.PrimitiveIterator;

public interface MessageService {
    int creatMsg(String content,String AcceptClass);
    HashMap<String,Object> getAllMsg(String searchInfo, Integer pageNum, Integer pageSize);
}
