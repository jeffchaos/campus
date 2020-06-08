package com.example.campus.service.impl;

import com.example.campus.entity.Product;
import com.example.campus.mapper.ProductMapper;
import com.example.campus.service.ProductService;
import com.example.campus.utils.GetIpAndPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuyy
 * @date 2020/6/6 20:43
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Value("${ip}")
    private String ip;

    @Autowired
    private GetIpAndPort getIpAndPort;
    @Override
    public List<Product> getAllProduct() {
        List<Product> productList = productMapper.selAll();
        convertImageUrl(productList);
        return productList;
    }

    @Override
    public int storeOneProduct(Product product) {
        return productMapper.insert(product);
    }

    @Override
    public void convertImageUrl(List<Product> productList) {
        productList.forEach(e->{
            System.out.println(ip+":"+getIpAndPort.getPort()+"/img/"+e.getImgsrc());
            e.setImgsrc("http://"+ip+":"+getIpAndPort.getPort()+"/img/"+e.getImgsrc());
        });
    }

    @Override
    public List<Product> getProductByType(String type) {
        List<Product> productList = productMapper.selByType(type);
        convertImageUrl(productList);
        return productList;
    }
}
