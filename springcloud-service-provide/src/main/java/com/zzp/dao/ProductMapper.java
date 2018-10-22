package com.zzp.dao;

import java.util.List;

import com.zzp.pojo.Product;

public interface ProductMapper {

    void addProduct(Product prouct);

    Product getProduct(Long productId);
    
    List<Product> getAllProduct();
    
    void deleteProductById(Long id);
    
}
