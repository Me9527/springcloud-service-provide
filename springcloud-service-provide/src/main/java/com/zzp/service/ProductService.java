package com.zzp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzp.dao.ProductMapper;
import com.zzp.pojo.Product;


@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public void addProduct(Product product) {
    	productMapper.addProduct(product);
    }

    public Product getProduct(Long productId) {
        return productMapper.getProduct(productId);
    }

    public List<Product> getAllProduct() {
        return productMapper.getAllProduct();
    }
    
    public void deleteProductById(Long id) {
    	productMapper.deleteProductById(id);
    }
    
}
