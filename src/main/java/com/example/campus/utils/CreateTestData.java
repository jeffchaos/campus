package com.example.campus.utils;

import com.example.campus.common.enums.BuyOrSellEnum;
import com.example.campus.common.enums.ProductTypeEnum;
import com.example.campus.common.enums.UpOrDownEnum;
import com.example.campus.entity.Post;
import com.example.campus.entity.Product;
import com.example.campus.mapper.PostMapper;
import com.example.campus.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

/**
 * @author yuyy
 * @date 2020/6/6 19:00
 */
@Component
public class CreateTestData {

    @Resource
    private ProductMapper productMapper;

    @Autowired
    private PostMapper postMapper;

    public void createDataOfProduct() {
        for (int i = 0; i < 500; i++) {
            productMapper.insert(Product.builder()
                    .title("学长二手电脑")
                    .decription("此电脑是我自己使用的，平时拿来写写代码，玩玩游戏。电脑是17年买的，无任何故障，运行流畅。有意者联系我！")
                    .price(2000.0)
                    .flag(BuyOrSellEnum.WANT_SELL.getCode())
                    .imgsrc("yuyy.info")
                    .publishTime(new Date())
                    .publishUserno("631607040632")
                    .status(UpOrDownEnum.UP.getCode())
                    .type(ProductTypeEnum.LIFE.getCode())
                    .build());
        }
    }

    public void createDataOfPost() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            postMapper.insert(Post.builder()
                    .posttype(random.nextInt(4))
                    .userno("631607040610")
                    .posttitle("我喜欢计科四班jc")
                    .postdetail("超级超级超级喜欢 求联系方式 但不喜欢ysc")
                    .imgurl("5.jpg")
                    .time(new Timestamp(
                            118,
                            random.nextInt(12) + 1,
                            random.nextInt(28) + 1,
                            random.nextInt(24),
                            random.nextInt(60),
                            random.nextInt(60),
                            random.nextInt(10000000)
                    ))
                    .status("还行")
                    .goods(0)
                    .bads(0)
                    .build()
            );
        }
    }
}
