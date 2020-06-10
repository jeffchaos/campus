package com.example.campus.service;

import com.example.campus.entity.Comment;
import com.sun.org.apache.xml.internal.security.Init;

import java.util.HashMap;
import java.util.List;

public interface CommentService {
    HashMap<String,Object> getAllComment(String searchInfo,Integer pageNum, Integer pageSize);
    int delComments(List<String> ids);
    int deleteByPrimaryKey(int commentid);
    List<Comment>  selCommentByPostId(int id);
    int insertComment (Comment comment);
}
