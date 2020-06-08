package com.example.campus.service;

import com.example.campus.entity.Product;

import java.util.List;

/**
 * @author yuyy
 * @date 2020/6/6 20:40
 */
public interface ProductService {
    List<Product> getAllProduct();

    int storeOneProduct(Product product);

    void convertImageUrl (List<Product> productList);

    List<Product> getProductByType(String type);

}
