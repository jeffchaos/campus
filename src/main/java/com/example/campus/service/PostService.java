package com.example.campus.service;

import com.example.campus.entity.Post;
import com.example.campus.mapper.PostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PostService {
    @Resource
    private PostMapper postMapper;

    public List<Post> selectAllPosts(){
        return postMapper.selectAllPosts();
    }

    public List<Post> getPostByType(String type){
        return postMapper.selPostByType(type);
    }
}
