package com.example.campus.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yuyy
 * @date 2020/6/6 21:37
 */
@Getter
@AllArgsConstructor
public enum BuyOrSellEnum {
    WANT_BUY("求购",1),
    WANT_SELL("出售",0);
    private String name;
    private Integer code;


    public static String getNameByCode(int code){
        String name = "";
        BuyOrSellEnum[] enums = BuyOrSellEnum.values();
        for (BuyOrSellEnum enumTemp : enums) {
            if(enumTemp.getCode()==code){
                name =  enumTemp.getName();
                break;
            }
        }
        return name;
    }

    public static Integer getCodeByName(String name){
        Integer code = null;
        BuyOrSellEnum[] enums = BuyOrSellEnum.values();
        for (BuyOrSellEnum enumTemp : enums) {
            if(enumTemp.getName().equals(name)){
                code =  enumTemp.getCode();
                break;
            }
        }
        return code;
    }
}
