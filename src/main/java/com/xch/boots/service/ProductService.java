package com.xch.boots.service;

import com.xch.boots.mapper.ProductMapper;
import com.xch.boots.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @package: com.xch.boots.service
 * @ClassName: ProductService
 * @author: 清欢.
 * @date: 2022/1/7 15:35
 */

@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;
    public Product getProductById(Integer id){
        return productMapper.getProduct(id);
    }

    public List<Product> getList(){
        return productMapper.getAllProduct();
    }
}
