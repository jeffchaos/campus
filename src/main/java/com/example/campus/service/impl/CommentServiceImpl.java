package com.example.campus.service.impl;

import com.example.campus.entity.Comment;
import com.example.campus.mapper.CommentMapper;
import com.example.campus.service.CommentService;
import com.sun.org.apache.xml.internal.security.Init;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public HashMap<String,Object> getAllComment(String searchInfo,Integer pageNum, Integer pageSize) {
        List<List<Comment>> list = commentMapper.getAllComment(searchInfo,(pageNum - 1) * pageSize,pageSize);
        List<Comment> list1=new ArrayList<>();
        HashMap<String,Object> data=new HashMap<>();
        list.get(0).forEach(
                e->{
                    //list1.add(e);
                    Collections.addAll(list1,e);
                }
        );
        data.put("commentList",list1);
        data.put("total",list.get(1).get(0));
        return data;
    }

    @Override
    public int delComments(List<String> ids) {
        commentMapper.delComments(ids);
        return 1;
    }

    @Override
    public int deleteByPrimaryKey(int commentid) {
        commentMapper.deleteByPrimaryKey(commentid);
        return 1;
    }

    @Override
    public List<Comment> selCommentByPostId(int id) {
        return commentMapper.selCommentByPostId(id);
    }

    @Override
    public int insertComment(Comment comment) {
        return  commentMapper.insert(comment);
    }
}
