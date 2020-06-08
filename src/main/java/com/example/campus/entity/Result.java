package com.example.campus.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * 返回数据给前端的信息实体类
 * @author yuyy
 * @date 20-2-19 下午2:37
 */
@Getter
@Setter
@ToString
public class Result {
    private Map<String,Object> data;
    private Meta meta;

    public Result(Map<String, Object> data, String status, String msg) {
        this.meta=new Meta(status,msg);
        this.data = data;
    }

    /**
     * 没有data
     * @param status
     * @param msg
     */
    public Result(String status,String msg) {
        this.meta=new Meta(status,msg);
    }

    public Result() {
    }
}

