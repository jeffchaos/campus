package com.example.campus.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.campus.entity.Product;
import com.example.campus.entity.Result;
import com.example.campus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author yuyy
 * @date 2020/6/6 20:30
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping ("products")
    public String getAllProduct(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("products",productService.getAllProduct());
        if(map.size()>0){
            return JSONObject.toJSONString(new Result(map,"200","success"));
        }
        return JSONObject.toJSONString(new Result("201","not found"));
    }

    @PostMapping("products")
    public String storeOneProduct(Product product){
        if(1==productService.storeOneProduct(product)){
            return JSONObject.toJSONString(new Result("200","success"));
        }
        return JSONObject.toJSONString(new Result("201","failure"));
    }


}
