package com.example.campus.controller;

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
import java.util.*;

/**
 * @author yuyy
 * @date 2020/6/6 20:30
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("products")
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
        Iterator<String> fileNames = multipartRequest.getFileNames();
        while (fileNames.hasNext()){
            String next = fileNames.next();
            MultipartFile file = files.get("pic_good0.jpg");

        }
//        if (multipartFile.isEmpty()) {
//            System.out.`intln("文件为空空");
//        }

        Enumeration params = request.getParameterNames();
        while (params.hasMoreElements()){
            String name = (String) params.nextElement();
            String value = request.getParameter(name);
            System.out.println(name+":"+value);
        }

        System.out.println("文件开始上传");
        String fileName = multipartFile.getOriginalFilename();  // 文件名
        System.out.println(fileName);
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        //上传到服务器之中了
//        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        String filePath = "E://imgsForCampusApp/";

        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs(); }
        try { multipartFile.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/temp-rainy/" + fileName;
        model.addAttribute("filename", filename);
        return "ok";
    }

    @GetMapping("products")
    public String getProductByType(String type){
        List<Product> product = productService.getProductByType(type);
        Map<String,Object> map=new HashMap<>();
        map.put("productList",product);
        return JSONObject.toJSONString(new Result(map,"200","success"));
    }
}
