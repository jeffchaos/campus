package com.example.campus.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.campus.entity.Product;
import com.example.campus.entity.Result;
import com.example.campus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yuyy
 * @date 2020/6/6 20:30
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("product")
    public String getAllProduct(){
        Map<String, Object> map = new HashMap<>();
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

    @RequestMapping(value = "upload")
    public String upload(/*@RequestParam(value = "file_upload")*/ MultipartFile multipartFile, HttpServletRequest request, Model model, MultipartRequest multipartRequest){
        Map<String,MultipartFile> files= multipartRequest.getFileMap();
        Product product = new Product();
        String filePath = "E://imgsForCampusApp/";
        JSONArray fileArray = new JSONArray();
        Iterator<String> fileNames = multipartRequest.getFileNames();
        while (fileNames.hasNext()){
            String next = fileNames.next();
            MultipartFile file = files.get(next);
            String s= UUID.randomUUID().toString();
            String extName = next.substring(next.lastIndexOf("."));
            String h= s.replace("-", "");
            String newName = s+extName;
            File newFile = new File(filePath+newName);
            if (!newFile.getParentFile().exists()) {
                newFile.getParentFile().mkdirs(); }
            try { file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileArray.add(newName);
        }
        product.setFlag(Integer.parseInt(request.getParameter("flag")));
        product.setDecription(request.getParameter("decription"));
        product.setPrice(Double.parseDouble(request.getParameter("price")));
        product.setType(Integer.parseInt(request.getParameter("type")));
        product.setPublishUserno(request.getParameter("publishUserno"));
        product.setNegotiable(Integer.parseInt(request.getParameter("negotiable")));
        product.setStatus(1);
        product.setImgsrc(JSON.toJSONString(fileArray));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        product.setPublishTime(Timestamp.valueOf(df.format(date)));
        product.setTitle(request.getParameter("title"));
        productService.storeOneProduct(product);


        return "ok";
    }

    @GetMapping("getProductsByType")
    public String getProductByType(String type){
        List<Product> product = productService.getProductByType(type);
        Map<String,Object> map=new HashMap<>();
        map.put("productList",product);
        return JSONObject.toJSONString(new Result(map,"200","success"));
    }

    @GetMapping("selectProductById")
    public String selectProductById(int id) {
        return JSON.toJSONString(productService.getProduct(id));
    }

    @GetMapping("selectPublishProduct")
    public String selectPublishProduct(String userno) {
        return JSON.toJSONString(productService.selectPublishProduct(userno));
    }
}
