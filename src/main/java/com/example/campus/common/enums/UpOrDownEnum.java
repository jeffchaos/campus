package com.example.campus.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yuyy
 * @date 2020/6/6 21:14
 */
@Getter
@AllArgsConstructor
public enum UpOrDownEnum {
    UP("上架",1),
    DOWN("下架",0);
    private String name;
    private Integer code;


    public static String getNameByCode(int code){
        String name = "";
        UpOrDownEnum[] enums = UpOrDownEnum.values();
        for (UpOrDownEnum enumTemp : enums) {
            if(enumTemp.getCode()==code){
                name =  enumTemp.getName();
                break;
            }
        }
        return name;
    }

    public static Integer getCodeByName(String name){
        Integer code = null;
        UpOrDownEnum[] enums = UpOrDownEnum.values();
        for (UpOrDownEnum enumTemp : enums) {
            if(enumTemp.getName().equals(name)){
                code =  enumTemp.getCode();
                break;
            }
        }
        return code;
    }
}
