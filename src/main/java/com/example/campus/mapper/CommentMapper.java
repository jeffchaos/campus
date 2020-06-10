package com.example.campus.mapper;

import com.example.campus.entity.Comment;
import com.sun.org.apache.xml.internal.security.Init;

import java.util.List;

public interface CommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbg.generated Tue Jun 02 17:06:36 CST 2020
     */
    int deleteByPrimaryKey(Integer commentid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbg.generated Tue Jun 02 17:06:36 CST 2020
     */
    int insert(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbg.generated Tue Jun 02 17:06:36 CST 2020
     */
    int insertSelective(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbg.generated Tue Jun 02 17:06:36 CST 2020
     */
    Comment selectByPrimaryKey(Integer commentid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbg.generated Tue Jun 02 17:06:36 CST 2020
     */
    int updateByPrimaryKeySelective(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbg.generated Tue Jun 02 17:06:36 CST 2020
     */
    int updateByPrimaryKey(Comment record);

    List<List<Comment>> getAllComment(String searchInfo,int start, int end);

    void delComments(List<String> ids);

    List<Comment> selCommentByPostId(int id);
}