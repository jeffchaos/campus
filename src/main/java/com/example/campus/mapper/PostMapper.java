package com.example.campus.mapper;

import com.example.campus.entity.Post;

import java.util.List;

public interface PostMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbg.generated Tue Jun 02 17:06:36 CST 2020
     */
    int deleteByPrimaryKey(Integer postid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbg.generated Tue Jun 02 17:06:36 CST 2020
     */
    int insert(Post record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbg.generated Tue Jun 02 17:06:36 CST 2020
     */
    int insertSelective(Post record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbg.generated Tue Jun 02 17:06:36 CST 2020
     */
    Post selectByPrimaryKey(Integer postid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbg.generated Tue Jun 02 17:06:36 CST 2020
     */
    int updateByPrimaryKeySelective(Post record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbg.generated Tue Jun 02 17:06:36 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(Post record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table post
     *
     * @mbg.generated Tue Jun 02 17:06:36 CST 2020
     */
    int updateByPrimaryKey(Post record);

    List<Post> selectAllPosts();

    List<Post> selPostByType(String type);
}