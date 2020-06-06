package com.example.campus.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yuyy
 * @date 2020/6/6 21:14
 */
@Getter
@AllArgsConstructor
public enum ProductTypeEnum {
    ALL("全部",0),
    STUDY("学习",1),
    LIFE("生活",2),
    PHYSICAL_EDUCATION("体育",3),
    OTHER("其他",4);
    private String name;
    private Integer code;


    public static String getNameByCode(int code){
        String name = "";
        ProductTypeEnum[] enums = ProductTypeEnum.values();
        for (ProductTypeEnum enumTemp : enums) {
            if(enumTemp.getCode()==code){
                name =  enumTemp.getName();
                break;
            }
        }
        return name;
    }

    public static Integer getCodeByName(String name){
        Integer code = null;
        ProductTypeEnum[] enums = ProductTypeEnum.values();
        for (ProductTypeEnum enumTemp : enums) {
            if(enumTemp.getName().equals(name)){
                code =  enumTemp.getCode();
                break;
            }
        }
        return code;
    }
}
