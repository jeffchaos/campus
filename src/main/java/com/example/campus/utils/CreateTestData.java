package com.example.campus.utils;

import com.example.campus.common.enums.BuyOrSellEnum;
import com.example.campus.common.enums.ProductTypeEnum;
import com.example.campus.common.enums.UpOrDownEnum;
import com.example.campus.entity.Product;
import com.example.campus.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author yuyy
 * @date 2020/6/6 19:00
 */
@Component
public class CreateTestData {

    @Resource
    private ProductMapper productMapper;

    public void createDataOfProduct(){
        for (int i = 0; i < 500; i++) {
            productMapper.insert(Product.builder()
                .title("学姐二手内衣")
                .decription("学姐自己穿的，太多了，毕业全拿走不方便，想卖一些。有兴趣得联系我哦！")
                .price(100.0)
                .flag(BuyOrSellEnum.WANT_SELL.getCode())
                .imgsrc("yuyy.info")
                .publishTime(new Date())
                .publishUserno("631607040632")
                .status(UpOrDownEnum.UP.getCode())
                .type(ProductTypeEnum.LIFE.getCode())
                .build());
        }
    }
}
