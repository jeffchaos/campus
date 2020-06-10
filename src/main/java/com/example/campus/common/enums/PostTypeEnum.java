package com.example.campus.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yuyy
 * @date 2020/6/6 21:37
 */
@Getter
@AllArgsConstructor
public enum PostTypeEnum {
    LOVE_WALL("表白墙",0),
    LOST_AND_FOUND("失物招领",1),
    Q_AND_A("互动问答",2),
    EXPERIENCE_OF_WORK("职场经验",3);
    private String name;
    private Integer code;


    public static String getNameByCode(int code){
        String name = "";
        PostTypeEnum[] enums = PostTypeEnum.values();
        for (PostTypeEnum enumTemp : enums) {
            if(enumTemp.getCode()==code){
                name =  enumTemp.getName();
                break;
            }
        }
        return name;
    }

    public static Integer getCodeByName(String name){
        Integer code = null;
        PostTypeEnum[] enums = PostTypeEnum.values();
        for (PostTypeEnum enumTemp : enums) {
            if(enumTemp.getName().equals(name)){
                code =  enumTemp.getCode();
                break;
            }
        }
        return code;
    }
}
